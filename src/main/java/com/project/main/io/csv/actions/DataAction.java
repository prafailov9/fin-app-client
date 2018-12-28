/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.io.csv.actions;

import java.io.File;
import java.io.Reader;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 * @param <T>
 */
public abstract class DataAction<T> {

    private final static Logger LOGGER = Logger.getLogger(DataAction.class.getCanonicalName());

    private final File file;
    private final Reader reader;
    private final CSVParser parser;
    private final List<CSVRecord> records;
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DataAction(final String filePath, final Reader reader, final CSVParser parser, List<CSVRecord> records) {
        this.file = new File(filePath);
        this.reader = reader;
        this.parser = parser;
        this.records = records;
    }

    public File getFile() {
        return file;
    }

    public Reader getReader() {
        return reader;
    }

    public CSVParser getParser() {
        return parser;
    }

    public DateTimeFormatter getDTF() {
        return DTF;
    }

    public List<CSVRecord> getRecords() {
        return records;
    }

    public abstract T parseLine();

    public abstract List<T> parseAll();

}
