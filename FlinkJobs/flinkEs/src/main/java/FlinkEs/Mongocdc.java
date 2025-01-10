package FlinkEs;
import Dto.NewEntry;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ververica.cdc.connectors.mongodb.source.MongoDBSource;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.api.common.serialization.SimpleStringSchema;

public class Mongocdc {
    public static void main(String[] args) throws Exception{
        MongoDBSource<String> sourceFunction = MongoDBSource.<String>builder()
                .hosts("192.168.1.27:27017")
                .databaseList("mynewdb") // set captured database, support regex
                .collectionList("mynewdb.myCollection") //set captured collections, support regex
                .deserializer(new JsonDebeziumDeserializationSchema())
                .build();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> mongoStream = env.fromSource(
                sourceFunction,
                WatermarkStrategy.noWatermarks(),
                "MongoDB CDC Source"
        );

        mongoStream.map(json -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, NewEntry.class);
        });

        KafkaSink<String> kafkaSink = KafkaSink.<String>builder()
                .setBootstrapServers("localhost:9092")
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                        .setTopic("my_topic")
                        .setValueSerializationSchema(new SimpleStringSchema())
                        .setKeySerializationSchema(new SimpleStringSchema())
                        .build()
                )
                .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();
        mongoStream.sinkTo(kafkaSink);
        env.execute("Mongo to kafka pipeline");
    }
}
