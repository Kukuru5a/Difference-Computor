package hexlet.code.Format;

import java.util.Map;
import java.util.List;
import java.util.Objects;

public class Plain {
    public static String fromPlain(List<Map<String, Object>> map) {
        StringBuilder reString = new StringBuilder();
        for (var diffs : map) {
            switch (diffs.get("status").toString()) {
                case "removed" -> reString.append("Property '").append(diffs.get("key"))
                        .append("' was removed\n");
                case "added" -> reString.append("Property '").append(diffs.get("key"))
                        .append("' was added with value: ").append(complexValueToString(diffs.get("new value"))).append("\n");
                case "changed" -> reString.append("Property '").append(diffs.get("key"))
                        .append("' was updated. From ").append(complexValueToString(diffs.get("old value"))).append(" to ")
                        .append(complexValueToString(diffs.get("new value"))).append("\n");
                default -> { }
            }
        }
        return reString.toString().trim();
    }

    public static String complexValueToString(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof List || value instanceof Map){
            return "[complex value]";
        } else if (value instanceof Integer || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return Objects.toString(value);
        }
    }
}
