package com.project.main.io.csv.actions.instrumentactions;

import com.project.main.data.instrument.CreditInstrument;
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
public class CreditInstrumentDataAction extends InstrumentDataAction<CreditInstrument> {

    public CreditInstrumentDataAction(String filePath, Reader reader, CSVParser parser, List<CSVRecord> records) {
        super(filePath, reader, parser, records);
    }

    @Override
    public List<CreditInstrument> parseAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CreditInstrument parseLine() {
        CreditInstrument creditInstrument = new CreditInstrument();
        List<CSVRecord> records = getRecords();

        for (CSVRecord record : records) {
            creditInstrument.setInstrumentName(record.get("InstrumentName"));
            creditInstrument.setInterestRate(Double.parseDouble(record.get("InterestRate")));
            creditInstrument.setStartOfPaymentPeriod(LocalDateTime.parse(record.get("startDate"), getDTF()));
            creditInstrument.setEndOfPaymentPeriod(LocalDateTime.parse(record.get("endDate"), getDTF()));
            creditInstrument.setInterestFrequency(Frequency.valueOf(record.get("interestFrequency")));
            creditInstrument.setPrincipalFrequency(Frequency.valueOf(record.get("principalFrequency")));
        }
        return creditInstrument;
    }

}
