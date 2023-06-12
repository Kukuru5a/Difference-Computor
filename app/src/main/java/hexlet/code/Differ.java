package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static Map<String, Object> getData(String content) throws Exception {
        var res = Files.readString(Paths.get(content));
        return Parser.parse(res);
    }

    public static Map<String, Object> getDiff(Map<String, Object> data1,
                                              Map<String, Object> data2) {
        Map<String, Object> resMap = new TreeMap<>();
        Set<String> keySet = new TreeSet<>(data1.keySet());
        keySet.addAll(data2.keySet());
        Map<String, Object> tm = new TreeMap<>();
        for (Map.Entry<String, Object> ss : data1.entrySet()) {
            for (Map.Entry<String, Object> rr : data2.entrySet()) {
                if (ss.getValue().equals(rr.getValue())) {
                    tm.put(" ".concat(ss.getKey()), ss.getValue());
                } else if (!ss.getValue().equals(rr.getValue())) {
                    tm.put("-".concat(ss.getKey()), ss.getValue());
                    tm.put("+".concat(rr.getKey()), rr.getValue());
                }
            }
            resMap.putAll(tm);
        }
        return resMap;
    }

    public static String generate(String dataFile1, String dataFile2) throws Exception {
        var dat1 = getData(dataFile1);
        var dat2 = getData(dataFile2);
        var difference = getDiff(dat1, dat2);
        var res = Formatter.format(difference, "json");
        return res;

    }
}