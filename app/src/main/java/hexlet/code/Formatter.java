package hexlet.code;


import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Format.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String jsonFormat(List<Map<String, Object>> fileDifference) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(fileDifference);
    }


    public static String format(List<Map<String, Object>> dataFile, String fileFormat) throws IOException {
        String res = "";
        switch (fileFormat) {
            case "json" -> res = jsonFormat(dataFile);
            case "stylish" -> res = Stylish.fromStylish(dataFile);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String content1 = "/Users/romazagorulya/java-project-71/app/src/test/java/resources/filePath1.json";
        String content2 = "/Users/romazagorulya/java-project-71/app/src/test/java/resources/filePath2.json";


        String generatedData = Differ.generate(content1, content2);
        System.out.println(generatedData);
    }
}
