package hexlet.code.Format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String fromYaml(List<Map<String, Object>> data) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

}

