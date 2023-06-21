package hexlet.code.Format;

import java.util.*;

public class Stylish {

    public static String fromStylish(List<Map<String, Object>> map) {
        StringBuilder reString = new StringBuilder();
        reString.append("{\n");
        for (var diffs : map) {
            switch (diffs.get("status").toString()) {
                case "removed" -> reString.append("  - ").append(complexValue(diffs.get("key"))).append(": ")
                        .append(complexValue(diffs.get("old value"))).append("\n");
                case "added" -> reString.append("  + ").append(complexValue(diffs.get("key"))).append(": ")
                        .append(complexValue(diffs.get("new value"))).append("\n");
                case "unchanged" -> reString.append("    ").append(complexValue(diffs.get("key"))).append(": ")
                        .append(complexValue(diffs.get("new value"))).append("\n");
                default -> {
                    reString.append("  - ").append(complexValue(diffs.get("key"))).append(": ")
                            .append(complexValue(diffs.get("old value"))).append("\n");
                    reString.append("  + ").append(complexValue(diffs.get("key"))).append(": ")
                            .append(complexValue(diffs.get("new value"))).append("\n");
                }
            }
        }
        reString.append("}");
        return reString.toString().trim();
    }
public static String complexValue(Object data) {
    if (data instanceof Object[] || data instanceof Collections || data instanceof Map
            || data instanceof ArrayList<?>) {
        return data.toString();
    } else if (data instanceof String) {
        return "'" + data + "'";
    } else if (data == null) {
        return null;
    }
    return data.toString();
}

}
