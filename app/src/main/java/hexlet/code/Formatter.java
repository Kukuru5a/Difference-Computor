package hexlet.code;

import hexlet.code.Format.Plain;
import hexlet.code.Format.Stylish;
import hexlet.code.Format.Json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {


    public static String format(List<Map<String, Object>> dataFile, String fileFormat) throws IOException {
        String res;
        if (fileFormat.equals("plain")) {
            res = Plain.fromPlain(dataFile);
        } else if (fileFormat.equals("class")) {
            res = Json.fromYaml(dataFile);
        } else if (fileFormat.equals("stylish")) {
            res = Stylish.fromStylish(dataFile);
        } else {
            res = "Format of '" + dataFile + "' is not supported.";
        }
        return res;
    }

    public static String format(List<Map<String, Object>> dataFile) throws IOException {
        return format(dataFile, "stylish");
    }

    public static void main(String[] args) throws Exception {
        String content1 = "src/test/resources/file1.json";
        String content2 = "src/test/resources/file2.json";

        String generatedData = Differ.generate(content1, content2, "json");
        System.out.println(generatedData);
    }
}
