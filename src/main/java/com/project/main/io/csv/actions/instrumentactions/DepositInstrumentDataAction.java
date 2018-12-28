/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.io.csv.actions.instrumentactions;

import com.project.main.data.instrument.DepositInstrument;
import com.project.main.data.instrument.frequency.Frequency;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 */
public class DepositInstrumentDataAction extends InstrumentDataAction<DepositInstrument> {

    public DepositInstrumentDataAction(String filePath, Reader reader, CSVParser parser, List<CSVRecord> records) {
        super(filePath, reader, parser, records);
    }

    @Override
    public DepositInstrument parseLine() {
        DepositInstrument depositInstrument = new DepositInstrument();
        List<CSVRecord> records = getRecords();

        for (CSVRecord record : records) {
            depositInstrument.setInstrumentName(record.get("InstrumentName"));
            depositInstrument.setInterestRate(Double.parseDouble(record.get("InterestRate")));
            depositInstrument.setStartOfPaymentPeriod(LocalDateTime.parse(record.get("startDate"), getDTF()));
            depositInstrument.setEndOfPaymentPeriod(LocalDateTime.parse(record.get("endDate"), getDTF()));
            depositInstrument.setInterestFrequency(Frequency.valueOf(record.get("interestFrequency")));
        }
        return depositInstrument;
    }

    @Override
    public List<DepositInstrument> parseAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
