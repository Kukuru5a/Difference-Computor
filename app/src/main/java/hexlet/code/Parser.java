package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String dataFile, String format) throws Exception {
        switch (format) {
            case "json" -> {
                return new ObjectMapper().readValue(dataFile, new TypeReference<>() {
                });
            }
            case "yml" -> {
                return new ObjectMapper(new YAMLFactory()).readValue(dataFile, new TypeReference<>() {
                });
            }
            default -> throw new RuntimeException("Transmitted type of format for'" + dataFile + "' is not supported.");
        }

    }
}
