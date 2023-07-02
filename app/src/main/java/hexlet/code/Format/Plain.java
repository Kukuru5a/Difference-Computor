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
                        .append("' was added with value: ").append(complexValue(diffs.get("new value"))).append("\n");
                case "changed" -> reString.append("Property '").append(diffs.get("key"))
                        .append("' was updated. From ").append(complexValue(diffs.get("old value"))).append(" to ")
                        .append(complexValue(diffs.get("new value"))).append("\n");
                default -> {}
            }
        }
        return reString.toString().trim();
    }

    public static String complexValue(Object value) {
        if (value == null) {
            return Objects.toString(null);
        } else if (value instanceof Integer || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return "[complex value]";
        }
    }
}
