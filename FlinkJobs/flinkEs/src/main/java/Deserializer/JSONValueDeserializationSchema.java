package Deserializer;

import Dto.Entry;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.util.Collector;

import java.io.IOException;

public class JSONValueDeserializationSchema implements DeserializationSchema<Entry> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void open(InitializationContext context) throws Exception {
        DeserializationSchema.super.open(context);
    }

    @Override
    public Entry deserialize(byte[] bytes) throws IOException {
        return objectMapper.readValue(bytes,Entry.class);
    }



    @Override
    public boolean isEndOfStream(Entry entry) {
        return false;
    }

    @Override
    public TypeInformation<Entry> getProducedType() {
        return TypeInformation.of(Entry.class);
    }
}
