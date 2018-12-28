package com.project.main.io.csv.actions.instrumentactions;

import com.project.main.data.instrument.Share;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 */
public class ShareDataAction extends InstrumentDataAction<Share> {

    public ShareDataAction(String filePath, Reader reader, CSVParser parser, List<CSVRecord> records) {
        super(filePath, reader, parser, records);
    }

    @Override
    public List<Share> parseAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Share parseLine() {
        Share share = new Share();
        List<CSVRecord> records = getRecords();

        for (CSVRecord record : records) {
            share.setInstrumentName(record.get("InstrumentName"));
            share.setStartOfPaymentPeriod(LocalDateTime.parse(record.get("startDate"), getDTF()));
            share.setEndOfPaymentPeriod(LocalDateTime.parse(record.get("endDate"), getDTF()));
        }
        return share;
    }

}
