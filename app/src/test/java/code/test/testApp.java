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
        String shortPath1 = "src/test/resources/file1.json";
        String shortPath2 = "src/test/resources/file2.json";
        String actualShort = Differ.generate(shortPath1, shortPath2);

        assertEquals(expected, actualShort);
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

        String shortPath1 = "src/test/resources/file1.yml";
        String shortPath2 = "src/test/resources/file2.yml";
        String actualShort = Differ.generate(shortPath1, shortPath2);

        assertEquals(expected, actualShort);
    }
    @Test
    void appTest3 () throws Exception {
        content1 = "src/test/resources/file3.json";
        content2 = "src/test/resources/file4.json";
        String actual = Differ.generate(content1,content2);
        String expected = "{\n" +
                "    chars1: [a, b, c]\n" +
                "  - chars2: [d, e, f]\n" +
                "  + chars2: false\n" +
                "  - checked: false\n" +
                "  + checked: true\n" +
                "  - default: null\n" +
                "  + default: [value1, value2]\n" +
                "  - id: 45\n" +
                "  + id: null\n" +
                "  - key1: value1\n" +
                "  + key2: value2\n" +
                "    numbers1: [1, 2, 3, 4]\n" +
                "  - numbers2: [2, 3, 4, 5]\n" +
                "  + numbers2: [22, 33, 44, 55]\n" +
                "  - numbers3: [3, 4, 5]\n" +
                "  + numbers4: [4, 5, 6]\n" +
                "  + obj1: {nestedKey=value, isNested=true}\n" +
                "  - setting1: Some value\n" +
                "  + setting1: Another value\n" +
                "  - setting2: 200\n" +
                "  + setting2: 300\n" +
                "  - setting3: true\n" +
                "  + setting3: none\n" +
                "}";
        assertEquals(expected, actual);
    }

}