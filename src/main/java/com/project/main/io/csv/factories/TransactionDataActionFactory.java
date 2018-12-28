package com.project.main.io.csv.factories;

import com.project.main.io.csv.actions.TransactionDataAction;
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
public class TransactionDataActionFactory {
    
      private final static String TRANSACTION_FILE_PATH = "/home/prafailov/opt/fin-app/inputFiles/transaction.csv";
    private final static String[] HEADERS = {"txDate", "amount", "sign"};
    private Reader fileReader;
    private CSVParser parser;
    private List<CSVRecord> records;

    public TransactionDataActionFactory() throws IOException {
        fileReader = new FileReader(new File(TRANSACTION_FILE_PATH));
        parser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader(HEADERS).withIgnoreHeaderCase().withTrim());
        records = parser.getRecords();

    }

    public TransactionDataAction createTransactionDataAction() {
        return new TransactionDataAction(TRANSACTION_FILE_PATH, fileReader, parser, records);
    }

    
}
