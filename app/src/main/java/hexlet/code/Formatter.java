package hexlet.code;

import hexlet.code.Format.Plain;
import hexlet.code.Format.Stylish;
import hexlet.code.Format.Yaml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {


    public static String format(List<Map<String, Object>> dataFile, String fileFormat) throws IOException {
        String res;
        if (fileFormat.equals("plain")) {
            res = Plain.fromPlain(dataFile);
        } else if (fileFormat.equals("yaml")) {
            res = Yaml.fromYaml(dataFile);
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
        String content1 = "src/test/resources/file_1.json";
        String content2 = "src/test/resources/file_2.json";

        String generatedData = Differ.generate(content1, content2, "stylish");
        System.out.println(generatedData);
    }
}
