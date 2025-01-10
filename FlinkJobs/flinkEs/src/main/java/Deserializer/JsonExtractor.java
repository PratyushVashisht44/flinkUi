package Deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonExtractor {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> extractFields(String json) throws Exception {
        // Parse JSON string into a Map
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});

        // Additional processing for specific fields (if needed)
        if (map.containsKey("_id")) {
            map.put("_id", map.get("_id").toString());
        }

        return map;
    }
}
