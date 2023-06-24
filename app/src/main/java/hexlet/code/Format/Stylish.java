package hexlet.code.Format;

import java.util.*;

public class Stylish {

    public static String fromStylish(List<Map<String, Object>> map) {
        StringBuilder reString = new StringBuilder();
        reString.append("{\n");
        for (var diffs : map) {
            switch (diffs.get("status").toString()) {
                case "removed" -> reString.append("  - ").append(diffs.get("key")).append(": ")
                        .append(complexValue(diffs.get("old value"))).append("\n");
                case "added" -> reString.append("  + ").append(diffs.get("key")).append(": ")
                        .append(complexValue(diffs.get("new value"))).append("\n");
                case "unchanged" -> reString.append("    ").append(diffs.get("key")).append(": ")
                        .append(complexValue(diffs.get("value"))).append("\n");
                default -> {
                    reString.append("  - ").append(diffs.get("key")).append(": ")
                            .append(complexValue(diffs.get("old value"))).append("\n");
                    reString.append("  + ").append(diffs.get("key")).append(": ")
                            .append(complexValue(diffs.get("new value"))).append("\n");
                }
            }
        }
        reString.append("}");
        return reString.toString().trim();
    }
public static String complexValue(Object value) {
        if (value == null) {
            return Objects.toString(null);
        } else if(value instanceof Integer || value instanceof Boolean) {
            return value.toString();
        }else if (value instanceof String) {
            return (String) value;
        } else {
            return value.toString();
        }
}
}
