package com.project.main.io.csv.factories;

import com.project.main.io.csv.actions.instrumentactions.CreditInstrumentDataAction;
import com.project.main.io.csv.actions.instrumentactions.DepositInstrumentDataAction;
import com.project.main.io.csv.actions.instrumentactions.InstrumentDataAction;
import com.project.main.io.csv.actions.instrumentactions.ShareDataAction;
import com.project.main.io.csv.exceptions.ActionDoesntExistException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 */
public class InstrumentDataActionFactory {

    private final static String INSTRUMENT_FILE_PATH = "/home/prafailov/opt/fin-app/inputFiles/instrument.csv";

    private Map<String, InstrumentDataAction> map;
    private String type;
    private Reader reader;
    private CSVParser parser;
    private List<CSVRecord> records;

    public InstrumentDataActionFactory() throws IOException {

        setUpReaderAndParser();

        map = new HashMap<>();
        map.put("CreditInstrument", new CreditInstrumentDataAction(INSTRUMENT_FILE_PATH, reader, parser, records));
        map.put("DepositInstrument", new DepositInstrumentDataAction(INSTRUMENT_FILE_PATH, reader, parser, records));
        map.put("Share", new ShareDataAction(INSTRUMENT_FILE_PATH, reader, parser, records));
    }

    public String extractType() throws IOException {
//        List<CSVRecord> records = parser.getRecords();
        records.forEach((record) -> setType(record.get("type")));
        return type;
    }

    public InstrumentDataAction getAction() {
        String typeLowerCase = type.toLowerCase();
        for (Map.Entry<String, InstrumentDataAction> entry : map.entrySet()) {
            String entryKey = entry.getKey().toLowerCase();
            if (entryKey.equals(typeLowerCase) || entryKey.contains(typeLowerCase)) {
                return entry.getValue();
            }
        }
        throw new ActionDoesntExistException();
    }

    private void setType(final String type) {
        this.type = type;
    }

    private void setUpReaderAndParser() throws IOException {
        reader = new FileReader(new File(INSTRUMENT_FILE_PATH));
        parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Type", "InstrumentName", "InterestRate",
                "startDate", "endDate", "interestFrequency", "principalFrequency")
                .withIgnoreHeaderCase()
                .withTrim());
        records = parser.getRecords();
        type = extractType();
    }

}
