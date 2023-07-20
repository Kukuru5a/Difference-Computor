package code.test;

import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestApp {
    private static final String CONTENT1_JSON = "./src/test/resources/file3.json";
    private static final String CONTENT2_JSON = "./src/test/resources/file4.json";
    private static final String CONTENT1_YML = "./src/test/resources/file1.yml";
    private static final String CONTENT2_YML = "./src/test/resources/file2.yml";
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;


    @BeforeAll
    static void init() throws IOException {
        expectedStylish = Files.readString(Path.of("./src/test/resources/expected-file1-stylish.txt"));
        expectedPlain = Files.readString(Path.of("./src/test/resources/expected-file1-plain.txt"));
        expectedJson = Files.readString(Path.of("./src/test/resources/expected-file-json.txt"));
    }
    @Test
    void appTestJsonAndYmlToStylish() throws Exception {
        String actual = Differ.generate(CONTENT1_JSON, CONTENT2_JSON, "stylish");
        assertEquals(expectedStylish, actual);
    }
    @Test
    void appTestYmlToStylish() throws Exception {
        String actual2 = Differ.generate(CONTENT1_YML, CONTENT2_YML, "stylish");
        assertEquals(expectedStylish, actual2);
    }

    @Test
    void appTestJsonAndYmlToDefault() throws Exception {
        String actual = Differ.generate(CONTENT1_JSON, CONTENT2_JSON);
        assertEquals(expectedStylish, actual);
    }
    @Test
            void appTestYmlToDefault() throws Exception {
        String actual2 = Differ.generate(CONTENT1_YML, CONTENT2_YML);
        assertEquals(expectedStylish, actual2);
    }

    @Test
    void appTestJsonAndYmlToPlain() throws Exception {
        String actual = Differ.generate(CONTENT1_JSON, CONTENT2_JSON, "plain");
        assertEquals(expectedPlain, actual);
    }
    @Test
    void appTestYmlToPlain() throws Exception {
        String actual2 = Differ.generate(CONTENT1_YML, CONTENT2_YML, "plain");
        assertEquals(expectedPlain, actual2);
    }
    @Test
    void appTestYmlToJson() throws Exception {
        String actual = Differ.generate(CONTENT1_YML, CONTENT2_YML, "json");
        assertEquals(expectedJson, actual);
    }
    @Test
    void appTestJsonToJson() throws Exception {
        String actual2 = Differ.generate(CONTENT1_JSON, CONTENT2_JSON, "json");
        assertEquals(expectedJson, actual2);
    }
}
