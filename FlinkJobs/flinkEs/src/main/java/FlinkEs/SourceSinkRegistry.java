package FlinkEs;

import com.ververica.cdc.connectors.mongodb.source.MongoDBSource;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;

import java.util.HashMap;
import java.util.Map;

public class SourceSinkRegistry {

    public static void main(String[] args) {
        // Create the registry map
        Map<String, Object> registry = new HashMap<>();

        // Add sources to the registry
        registry.put("mongoSource", createMongoSource());
        registry.put("kafkaSink", createKafkaSink());

        // Example usage: Retrieve a source or sink by key
        Object sourceObject = registry.get("mongoSource");
        if (sourceObject instanceof MongoDBSource) {
            System.out.println("MongoDBSource created: " + sourceObject);
        }

        Object sinkObject = registry.get("kafkaSink");
        if (sinkObject instanceof KafkaSink) {
            System.out.println("KafkaSink created: " + sinkObject);
        }
    }

    // Create MongoDB Source
    private static MongoDBSource<String> createMongoSource() {
        return MongoDBSource.<String>builder()
                .hosts("192.168.1.27:27017")
                .databaseList("mynewdb") // Set captured database
                .collectionList("mynewdb.myCollection") // Set captured collections
                .deserializer(new JsonDebeziumDeserializationSchema())
                .build();
    }

    // Create Kafka Sink
    private static KafkaSink<String> createKafkaSink() {
        return KafkaSink.<String>builder()
                .setBootstrapServers("localhost:9092")
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                        .setTopic("my_topic")
                        .setValueSerializationSchema(new SimpleStringSchema())
                        .build()
                )
                .build();
    }
}
