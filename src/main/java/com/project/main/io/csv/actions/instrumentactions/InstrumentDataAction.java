/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.io.csv.actions.instrumentactions;

import com.project.main.io.csv.actions.DataAction;
import java.io.Reader;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 * @param <Instrument>
 */
public abstract class InstrumentDataAction<Instrument> extends DataAction<Instrument> {

    public InstrumentDataAction(String filePath, Reader reader, CSVParser parser, List<CSVRecord> records) {
        super(filePath, reader, parser, records);
    }

    @Override
    public abstract List<Instrument> parseAll();

}
