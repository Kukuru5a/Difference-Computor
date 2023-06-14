package hexlet.code.Format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String fromStylish(List<Map<String, Object>> map) {
        String res;
        StringBuilder reString = new StringBuilder();
        for (var diffs : map) {
            switch (diffs.get("status").toString()) {
                case "removed" -> reString.append("- ").append(diffs.get("key")).append(": ")
                        .append("old value").append("\n");
                case "added" -> reString.append("+ ").append(diffs.get("key")).append(": ")
                        .append("new value").append("\n");
                case "unchanged" -> reString.append("  ").append(diffs.get("key")).append(": ")
                        .append("old value").append("\n");
                default -> {
                    reString.append("- ").append(diffs.get("key")).append(": ")
                            .append("old value").append("\n");
                    reString.append("+ ").append(diffs.get("key")).append(": ")
                            .append("new value").append("\n");
                }
            }
        }
        return reString.toString().trim();
    }
}
