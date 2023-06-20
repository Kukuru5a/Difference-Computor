package hexlet.code;

import hexlet.code.Format.Stylish;
import hexlet.code.Format.Yaml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {


    public static String format(List<Map<String, Object>> dataFile, String fileFormat) throws IOException {
        String res = "";
        switch (fileFormat) {
            case "stylish" -> res = Stylish.fromStylish(dataFile);
            case "yaml" -> res = Yaml.fromYaml(dataFile);
            default -> res = "Format of '" + dataFile + "' is not supported.";
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        String content1 = "src/test/resources/file1.yml";
        String content2 = "src/test/resources/file2.yml";

        String generatedData = Differ.generate(content1, content2, "yaml");
        System.out.println(generatedData);
    }
}
