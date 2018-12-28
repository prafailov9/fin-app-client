package com.project.writers;

import com.project.main.data.generator.DateTimeValuesGenerator;
import com.project.main.data.instrument.CreditInstrument;
import com.project.main.data.instrument.frequency.Frequency;
import com.project.main.data.position.Position;
import com.project.main.data.results.CreditResultObject;
import com.project.main.io.printers.ResultObjectPrinter;
import java.time.LocalDateTime;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prafailov
 */
public class ResultObjectPrinterTestCase {

    private final static String FILE_DESTINATION
            = "/home/prafailov/opt/fin-app/fin-app-client/trunk/rest-client/src/main/resources/calculation-results.csv";
    private ResultObjectPrinter rop;
    private CreditResultObject cro;
    private DateTimeValuesGenerator gen;

    @Before
    public void setUp() {
        rop = new ResultObjectPrinter();
        gen = new DateTimeValuesGenerator();

        cro = new CreditResultObject(gen.generateRandomData(20), createPositionEntity(), "credit", gen.generateRandomData(20));

    }

    @After
    public void tearDown() {
        rop = null;
        cro = null;
        gen = null;
    }

    @Test
    public void printCroTest() {
        boolean actual = rop.printCreditResults(cro, FILE_DESTINATION);

        assertTrue(actual);

    }

    // 18	2005-03-01 16:17:46.0	fid	tsc			13
//   13	inst14	0.09	2005-03-01 16:17:46.0	2015-03-01 22:11:22.0	MONTHLY	ANNUALLY	credit
    private Position createPositionEntity() {
        CreditInstrument ins = new CreditInstrument(
                "inst", LocalDateTime.parse("2005-03-01 16:17:46", gen.getFormatter()),
                LocalDateTime.parse("2015-03-01 22:11:22", gen.getFormatter()),
                0.09, Frequency.ANNUALLY, Frequency.WEEKLY);

        Position pos = new Position(LocalDateTime.parse("2005-03-01 16:17:46", gen.getFormatter()), "dasdasd", "adad", ins, 1000, 100);
        return pos;
    }

}
