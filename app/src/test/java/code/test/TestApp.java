package code.test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestApp {
    private static String content1;
    private static String content2;

    @Test
    void appTest() throws Exception {
        content1 = "./src/test/resources/file1.json";
        content2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(content1, content2, "stylish");
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, actual);
        String shortPath1 = "src/test/resources/file1.json";
        String shortPath2 = "src/test/resources/file2.json";
        String actualShort = Differ.generate(shortPath1, shortPath2, "stylish");

        assertEquals(expected, actualShort);
    }

    @Test
    void appTest2() throws Exception {
        content1 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file1.yml";
        content2 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file2.yml";
        String actual = Differ.generate(content1, content2);
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, actual);

        String shortPath1 = "src/test/resources/file1.yml";
        String shortPath2 = "src/test/resources/file2.yml";
        String actualShort = Differ.generate(shortPath1, shortPath2);

        assertEquals(expected, actualShort);
    }

    @Test
    void appTest3() throws Exception {
        content1 = "src/test/resources/file3.json";
        content2 = "src/test/resources/file4.json";
        String actual = Differ.generate(content1, content2);
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    void appTest4() throws Exception {
        content1 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file_1.yml";
        content2 = "/Users/romazagorulya/java-project-71/app/src/test/resources/file_2.yml";
        String actual = Differ.generate(content1, content2, "stylish");
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, actual);
        String shortPath1 = "src/test/resources/file_1.yml";
        String shortPath2 = "src/test/resources/file_2.yml";
        String actualShort = Differ.generate(shortPath1, shortPath2, "stylish");

        assertEquals(expected, actualShort);
    }

    @Test
    void appTest5() throws Exception {
        content1 = "./src/test/resources/file3.json";
        content2 = "./src/test/resources/file4.json";
        String expected = "{\n"
                + "  Property 'chars1 is unchanged. Value null is up-to-date.\n"
                + "  Property 'chars2' was updated. From [complex value] to false\n"
                + "  Property 'checked' was updated. From false to true\n"
                + "  Property 'default' was updated. From null to [complex value]\n"
                + "  Property 'id' was updated. From 45 to null\n"
                + "  Property 'key1' was removed. \n"
                + "  Property 'key2' was added. With value 'value2'\n"
                + "  Property 'numbers1 is unchanged. Value null is up-to-date.\n"
                + "  Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "  Property 'numbers3' was removed. \n"
                + "  Property 'numbers4' was added. With value [complex value]\n"
                + "  Property 'obj1' was added. With value [complex value]\n"
                + "  Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "  Property 'setting2' was updated. From 200 to 300\n"
                + "  Property 'setting3' was updated. From true to 'none'\n"
                + "}";
        String actual = Differ.generate(content1, content2, "plain");
        assertEquals(expected, actual);
    }
}
