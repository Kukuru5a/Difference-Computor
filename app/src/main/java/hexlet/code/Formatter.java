package hexlet.code;

import hexlet.code.Format.Plain;
import hexlet.code.Format.Stylish;
import hexlet.code.Format.Json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> dataFile, String fileFormat) throws IOException {
        switch (fileFormat) {
            case "plain" -> {
                return Plain.fromPlain(dataFile);
            }
            case "json" -> {
                return Json.fromYaml(dataFile);
            }
            case "stylish" -> {
                return Stylish.fromStylish(dataFile);
            }
            default -> throw new RuntimeException("Format of '" + dataFile + "' is not supported.");
        }
    }
}
