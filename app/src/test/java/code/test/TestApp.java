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
    private static String EXPECTED_STYLISH;
    private static String EXPECTED_PLAIN;
    private static String EXPECTED_JSON;


    @BeforeAll
    static void init() throws IOException {
        EXPECTED_STYLISH = Files.readString(Path.of("./src/test/resources/expected-file1-stylish.txt"));
        EXPECTED_PLAIN = Files.readString(Path.of("./src/test/resources/expected-file1-plain.txt"));
        EXPECTED_JSON = Files.readString(Path.of("./src/test/resources/expected-file-json.txt"));
    }
    @Test
    void appTestJsonAndYmlToStylish() throws Exception {
        String actual = Differ.generate(CONTENT1_JSON, CONTENT2_JSON, "stylish");
        assertEquals(EXPECTED_STYLISH, actual);

        String actual2 = Differ.generate(CONTENT1_YML, CONTENT2_YML, "stylish");
        assertEquals(EXPECTED_STYLISH, actual2);
    }

    @Test
    void appTestJsonAndYmlToDefault() throws Exception {
        String actual = Differ.generate(CONTENT1_JSON, CONTENT2_JSON);
        assertEquals(EXPECTED_STYLISH, actual);

        String actual2 = Differ.generate(CONTENT1_YML, CONTENT2_YML);
        assertEquals(EXPECTED_STYLISH, actual2);
    }

    @Test
    void appTestJsonAndYmlToPlain() throws Exception {
        String actual = Differ.generate(CONTENT1_JSON, CONTENT2_JSON, "plain");
        assertEquals(EXPECTED_PLAIN, actual);

        String actual2 = Differ.generate(CONTENT1_YML, CONTENT2_YML, "plain");
        assertEquals(EXPECTED_PLAIN, actual2);
    }
    @Test
    void appTestYmlAndJsonToJson() throws Exception {
        String actual = Differ.generate(CONTENT1_YML, CONTENT2_YML, "json");
        assertEquals(EXPECTED_JSON, actual);

        String actual2 = Differ.generate(CONTENT1_JSON, CONTENT2_JSON, "json");
        assertEquals(EXPECTED_JSON, actual2);
    }
}
