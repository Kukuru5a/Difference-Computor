package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Differ   {




    public static Map<String, Map<String, Object>> getDiff (Map<String, Object> data1,
                                                            Map<String, Object> data2) {
        Map<String, Map<String, Object>> resMap = new TreeMap<>();
        Set<String> keySet = new TreeSet<>(data1.keySet());
        keySet.addAll(data2.keySet());

        for (var key : keySet) {
            Map<String, Object> tMap = new TreeMap<>();
            if (!data1.containsKey(key)) {
                tMap.put("+", data2.get(key));
            } else if (!data2.containsKey(key)) {
                tMap.put("-", data1.get(key));
            } else {
                if (data1.get(key).equals(data2.get(key))) {
                    tMap.put("", data1);
                }
            }
            resMap.put(key, tMap);
        }
        return resMap;
    }
    public static String generate (String n, String m, String format) throws Exception {
        var data1 = getData(n);
        var data2 = getData(m);
        var res = getDiff(data1, data2);

        return res.toString();
    }

    public static Map<String, Object> getData(String content) throws Exception { // переделать json в path достать контент
        String path = Files.readString(Paths.get(content));
        return Parser.parse(path);
    }
}
