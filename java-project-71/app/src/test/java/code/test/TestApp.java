package code.test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestApp {
    private static String content1;
    private static String content2;

    @Test
    void appTest() throws Exception {
        content1 = "./src/test/resources/file1.json";
        content2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(content1, content2, "stylish");
        String expected = Files.readString(Path.of("./src/test/resources/expected-file1-stylish.txt"));
        assertEquals(expected, actual);
        String shortPath1 = "src/test/resources/file1.json";
        String shortPath2 = "src/test/resources/file2.json";
        String actualShort = Differ.generate(shortPath1, shortPath2, "stylish");

        assertEquals(expected, actualShort);
    }

    @Test
    void appTest2() throws Exception {
        content1 = "./src/test/resources/file1.yml";
        content2 = "./src/test/resources/file2.yml";
        String actual = Differ.generate(content1, content2);
        String expected = Files.readString(Path.of("./src/test/resources/expected-file1-stylish.txt"));
        assertEquals(expected, actual);
    }

    @Test
    void appTest3() throws Exception {
        content1 = "./src/test/resources/file3.json";
        content2 = "./src/test/resources/file4.json";
        String actual = Differ.generate(content1, content2);
        String expected = Files.readString(Path.of("./src/test/resources/expected-file2-stylish.txt"));
        assertEquals(expected, actual);
    }

    @Test
    void appTest4() throws Exception {
        content1 = "./src/test/resources/file_1.yml";
        content2 = "./src/test/resources/file_2.yml";
        String actual = Differ.generate(content1, content2);
        String expected = Files.readString(Path.of("./src/test/resources/expected-file2-stylish.txt"));
        assertEquals(expected, actual);
    }

    @Test
    void appTest5() throws Exception {
        content1 = "./src/test/resources/file1.json";
        content2 = "./src/test/resources/file2.json";
        String expected = Files.readString(Path.of("./src/test/resources/expected-file1-plain.txt"));
        String actual = Differ.generate(content1, content2, "plain");
        assertEquals(expected, actual);
    }
    @Test
    void appTest6() throws Exception {
        content1 = "./src/test/resources/file_1.yml";
        content2 = "./src/test/resources/file_2.yml";
        String expected = Files.readString(Path.of("./src/test/resources/expected-file2-plain.txt"));
        String actual = Differ.generate(content1, content2, "plain");
        assertEquals(expected, actual);
    }
    @Test
    void appTest7() throws Exception {
        content1 = "./src/test/resources/file_1.yml";
        content2 = "./src/test/resources/file_2.yml";
        String expected = Files.readString(Path.of("./src/test/resources/expected-file-json.txt"));
        String actual = Differ.generate(content1, content2, "json");
        assertEquals(expected, actual);
    }
}
