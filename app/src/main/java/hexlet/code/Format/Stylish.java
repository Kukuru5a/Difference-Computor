package hexlet.code.Format;

import java.util.*;

public class Stylish {
    public static String fromStylish(List<Map<String, Object>> map) {
        StringBuilder reString = new StringBuilder();
        reString.append("{\n");
        for (var diffs : map) {
                switch (diffs.get("status").toString()) {
                    case "removed" -> reString.append("  - ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("old value")).append("\n");
                    case "added" -> reString.append("  + ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("new value")).append("\n");
                    case "unchanged" -> reString.append("    ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("value")).append("\n");
                    default -> {
                        reString.append("  - ").append(diffs.get("key")).append(": ")
                                .append(diffs.get("old value")).append("\n");
                        reString.append("  + ").append(diffs.get("key")).append(": ")
                                .append(diffs.get("new value")).append("\n");
                    }
                }
            }
        reString.append("}");
        return reString.toString().trim();
    }
}
