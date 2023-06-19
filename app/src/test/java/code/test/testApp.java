package code.test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testApp {
    private static final String content1 = "/Users/romazagorulya/java-project-71/app/src/test/java/resources/filePath1.json";
    private static final String content2 = "/Users/romazagorulya/java-project-71/app/src/test/java/resources/filePath2.json";
    @Test
    void appTest() throws Exception {
        String actual = Differ.generate(content1, content2);
        String expected = "{\n" +
                "  - follow: false\n" +
                "    host: hexlet.io\n" +
                "  - proxy: 123.234.53.22\n" +
                "  - timeout: 50\n" +
                "  + timeout: 20\n" +
                "  + verbose: true\n" +
                "}";
        assertEquals(expected, actual);
    }
}