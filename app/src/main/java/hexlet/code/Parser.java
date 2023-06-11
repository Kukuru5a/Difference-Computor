package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse (String dataFile) throws Exception {
        return new ObjectMapper().readValue(dataFile, new TypeReference<>() { });
    }

}
