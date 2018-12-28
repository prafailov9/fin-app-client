package com.project.main.io.csv.factories;

import com.project.main.io.csv.actions.PositionDataAction;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 */
public class PositionDataActionFactory {

    private final static String POSITION_FILE_PATH = "/home/prafailov/opt/fin-app/inputFiles/position.csv";
    private final static String[] HEADERS = {"startDate", "payer", "receiver", "principal", "positionVolume"};
    private Reader fileReader;
    private CSVParser parser;
    private List<CSVRecord> records;

    public PositionDataActionFactory() throws IOException {
        fileReader = new FileReader(new File(POSITION_FILE_PATH));
        parser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader(HEADERS).withIgnoreHeaderCase().withTrim());
        records = parser.getRecords();

    }

    public PositionDataAction createPositionDataAction() {
        return new PositionDataAction(POSITION_FILE_PATH, fileReader, parser, records);
    }

}
