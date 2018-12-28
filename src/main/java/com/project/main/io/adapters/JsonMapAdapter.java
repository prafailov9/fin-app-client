package com.project.main.io.adapters;

import com.project.main.io.parsers.JsonResultsMapDeserializer;
import com.project.main.io.parsers.JsonMapParser;
import java.time.LocalDateTime;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author prafailov
 */
public class JsonMapAdapter extends XmlAdapter<String, Map<LocalDateTime, Double>> {

    private final JsonMapParser<LocalDateTime, Double> parser = new JsonMapParser<>();
    private final JsonResultsMapDeserializer jp = new JsonResultsMapDeserializer();

    @Override
    public Map<LocalDateTime, Double> unmarshal(String stringMap) throws Exception {
        Map<LocalDateTime, Double> resultsMap = jp.deserialize(stringMap);

        return resultsMap;

    }

    @Override
    public String marshal(Map<LocalDateTime, Double> resultsMap) throws Exception {
        String stringMap = parser.toJsonString(resultsMap);
        return stringMap;
    }

}
