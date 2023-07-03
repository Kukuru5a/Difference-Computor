package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.DataFormatException;

public class Differ {
    public static Map<String, Object> getData(String content) throws Exception {
        var res = Files.readString(Paths.get(content));
        var ext = getFormat(content);
        return Parser.parse(res, ext);
    }

    private static String getFormat(String path) throws Exception {
        if (!path.contains(".")) {
            throw new DataFormatException();
        }
        int indexOfLastDot = path.lastIndexOf(".") + 1;
        return path.substring(indexOfLastDot, path.length()).toLowerCase();
    }

    public static String generate(String dataFile1, String dataFile2, String format) throws Exception {
        var dat1 = getData(dataFile1);
        var dat2 = getData(dataFile2);
        var difference = DiffBuilder.getDiff(dat1, dat2);
        var res = Formatter.format(difference, format);
        return res;
    }

    public static String generate(String dataFile1, String dataFile2) throws Exception {
        return generate(dataFile1, dataFile2, "stylish");
    }
}
