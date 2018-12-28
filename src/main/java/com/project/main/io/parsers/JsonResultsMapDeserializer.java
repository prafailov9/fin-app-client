package com.project.main.io.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.project.main.io.adapters.LocalDateTimeAdapter;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prafailov
 */
public class JsonResultsMapDeserializer {

    protected final static Logger LOGGER = Logger.getLogger(JsonResultsMapDeserializer.class.getCanonicalName());

    private final static Gson gson = new GsonBuilder().create();
    private final LocalDateTimeAdapter ldtAdapter = new LocalDateTimeAdapter();
    private final Type mapType = new TypeToken<Map<String, Double>>() {
    }.getType();

    public Map<LocalDateTime, Double> deserialize(String jsonMap) throws Exception {
        Map<String, Double> intermediateMap = gson.fromJson(jsonMap, mapType);
        Map<LocalDateTime, Double> resultsMap = new TreeMap<>();
        try {

            for (Entry<String, Double> entry : intermediateMap.entrySet()) {
                String key = cleanUpString(entry.getKey());
                LocalDateTime ldt = ldtAdapter.unmarshal(key);
                Double value = entry.getValue();
                resultsMap.put(ldt, value);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return resultsMap;
    }

    private String cleanUpString(String str) {
        if (str.contains("T")) {
            return str.replace("T", " ");
        }
        // no cleaning neaded;
        return str;
    }

}
