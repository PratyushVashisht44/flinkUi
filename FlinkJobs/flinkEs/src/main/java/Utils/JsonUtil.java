package Utils;

import Dto.Entry;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertEntryToJson(Entry entry){
        try {
            return objectMapper.writeValueAsString(entry);
        }catch (org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException e){
            e.printStackTrace();
            return null;
        }
    }
}
