package com.project.json;

import com.project.main.data.generator.DateTimeValuesGenerator;
import com.project.main.io.parsers.JsonMapParser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prafailov
 */
public class JsonMapParserTestCase {

    private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private DateTimeValuesGenerator gen = new DateTimeValuesGenerator();
    private JsonMapParser<LocalDateTime, Double> parser;
    private String jsonMap;

    @Before
    public void setUp() {
        parser = new JsonMapParser<>();
        Map<LocalDateTime, Double> map = gen.generateRandomData(10);
        jsonMap = parser.toJsonString(map);
    }

    @After
    public void tearDown() {
        parser = null;
    }

    @Test
    public void parseToMapTest() {

        Map<LocalDateTime, Double> map = parser.toMap(jsonMap);
        System.out.println(map.toString());
        assertNotNull(map);

    }

}
