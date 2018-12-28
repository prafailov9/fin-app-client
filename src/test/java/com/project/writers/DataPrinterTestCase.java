package com.project.writers;

import com.project.main.data.results.ResultObject;
import com.project.main.io.printers.DataPrinter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVPrinter;

/**
 *
 * @author prafailov
 */
public class DataPrinterTestCase {

    private final static String CSV_FILE = "/home/prafailov/opt/fin-app/fin-app-client/trunk/rest-client/src/main/resources/pos-info.csv";
    private Appendable appendable;
    private CSVPrinter printer;
    private ResultObject dro;
    private DataPrinter dp;

//    @Before
//    public void setUp() throws IOException {
//        dp = new FileDataPrinter(CSV_FILE);
//        dro = new DepositResultObject(createCashFlow(), Long.MIN_VALUE, "deposit");
//        BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
//        this.appendable = writer;
//        this.printer = CSVFormat.DEFAULT.print(appendable);
//    }
//
//    @After
//    public void tearDown() {
//        appendable = null;
//        printer = null;
//    }
//
//    @Test
//    public void printDataTest() {
//
//        boolean actual = dp.print(dro.toString());
//
//        assertTrue(actual);
//    }

//    @Test
    public void writeDataToFileTest() throws IOException {
        String droStr = dro.toString();
        printer.printRecords(droStr);
        printer.flush();
    }

    private Map<LocalDateTime, Double> createCashFlow() {
        Map<LocalDateTime, Double> cashFlow = new HashMap<>();
        cashFlow.put(LocalDateTime.now(), 1d);
        cashFlow.put(LocalDateTime.now(), 2d);
        cashFlow.put(LocalDateTime.now(), 3d);
        cashFlow.put(LocalDateTime.now(), 4d);
        return cashFlow;
    }
}
