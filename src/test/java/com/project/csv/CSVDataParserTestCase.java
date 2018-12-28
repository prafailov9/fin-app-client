package com.project.csv;

import com.project.main.io.csv.CSVDataParser;
import com.project.main.io.csv.actions.DataAction;
import com.project.main.io.csv.factories.InstrumentDataActionFactory;
import com.project.main.io.csv.factories.PositionDataActionFactory;
import com.project.main.io.csv.factories.TransactionDataActionFactory;
import com.project.main.data.instrument.Instrument;
import com.project.main.data.position.Position;
import com.project.main.data.transactions.Transaction;
import java.io.IOException;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prafailov
 */
public class CSVDataParserTestCase {

    private CSVDataParser<Position> posParser;
    private CSVDataParser<Instrument> insParser;
    private CSVDataParser<Transaction> txParser;

    public CSVDataParserTestCase() {
    }

    @Before
    public void setUp() throws IOException {
        PositionDataActionFactory pdf = new PositionDataActionFactory();
        InstrumentDataActionFactory idf = new InstrumentDataActionFactory();
        TransactionDataActionFactory tdf = new TransactionDataActionFactory();
        DataAction<Position> pda = pdf.createPositionDataAction();
        DataAction<Instrument> ida = idf.getAction();
        DataAction<Transaction> tda = tdf.createTransactionDataAction();
        
        posParser = new CSVDataParser(pda);
        insParser = new CSVDataParser(ida);
        txParser = new CSVDataParser(tda);
    }

    @After
    public void tearDown() {
        posParser = null;
    }

    @Test
    public void createPositionTest() {
        
        Position pos = posParser.parseData();
        assertNotNull(pos);
    }
    
    @Test
    public void createTrasnactionTest() {
        Transaction tx = txParser.parseData();
        assertNotNull(tx);
    }
    
    @Test
    public void createInstrumentTest() {
        Instrument ins = insParser.parseData();
        assertNotNull(ins);
    }
    
}
