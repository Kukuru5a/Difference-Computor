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
        switch (fileFormat) {
            case "plain" -> res = Plain.fromPlain(dataFile);
            case "json" -> res = Json.fromYaml(dataFile);
            case "stylish" -> res = Stylish.fromStylish(dataFile);
            default -> throw new RuntimeException("Format of '" + dataFile + "' is not supported.");
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        var f1 = "./src/test/resources/file1.yml";
        var f2 = "./src/test/resources/file2.yml";

        var s = Differ.generate(f1,f2,"plain");
        System.out.println(s);
    }
}
