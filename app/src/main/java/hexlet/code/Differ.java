package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static Map<String, Object> getData(String content) throws Exception {
        var res = Files.readString(Paths.get(content));
        return Parser.parse(res);
    }

    public static List<Map<String, Object>> getDiff(Map<String, Object> data1,
                                                    Map<String, Object> data2) {
        List<Map<String, Object>> resList = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(data1.keySet());
        keySet.addAll(data2.keySet());

        for (String key : keySet) {
            Map<String, Object> tm = new TreeMap<>();

            if (!data1.containsKey(key)) {
                tm.put("key", key);
                tm.put("new value", data2.get(key));
                tm.put("status", "added");
            }else if (!data2.containsKey(key)) {
                tm.put("key", key);
                tm.put("old value", data1.get(key));
                tm.put("status", "removed");
            } else if (data1.get(key).equals(data2.get(key))) {
                tm.put("key", key);
                tm.put("value", data2.get(key));
                tm.put("status", "unchanged");
            } else {
                tm.put("key", key);
                tm.put("old value", data1.get(key));
                tm.put("new value", data2.get(key));
                tm.put("status", "changed");
            }
            resList.add(tm);
        }
        return resList;
    }

    public static String generate(String dataFile1, String dataFile2, String format) throws Exception {
        var dat1 = getData(dataFile1);
        var dat2 = getData(dataFile2);
        var difference = getDiff(dat1, dat2);
        var res = Formatter.format(difference, format);
        return res;
    }
    public static String generate(String dataFile1, String dataFile2) throws Exception {
        return generate(dataFile1, dataFile2, "stylish");
    }
}