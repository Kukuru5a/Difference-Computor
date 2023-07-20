package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Objects;
public class DiffBuilder {
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
            } else if (!data2.containsKey(key)) {
                tm.put("key", key);
                tm.put("old value", data1.get(key));
                tm.put("status", "removed");
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
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
}
