package code.test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testApp {
    private static String content1;
    private static String content2;
    @Test
    void appTest() throws Exception {
        content1 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file1.json";
        content2 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file2.json";
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
    @Test
    void appTest2() throws Exception {
        content1 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file1.yml";
        content2 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file2.yml";
        String actual = Differ.generate(content1, content2, "yaml");
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