package com.project.main;

import com.project.main.clients.calculationclient.CalculationClient;
import com.project.main.clients.instrumentclient.InstrumentClient;
import com.project.main.clients.positionclient.PositionClient;
import com.project.main.clients.transactionclient.TransactionClient;
import com.project.main.data.instrument.Instrument;
import com.project.main.data.position.Position;
import com.project.main.data.results.CreditResultObject;
import com.project.main.data.transactions.Transaction;
import com.project.main.io.csv.CSVDataParser;
import com.project.main.io.csv.actions.DataAction;
import com.project.main.io.csv.factories.InstrumentDataActionFactory;
import com.project.main.io.csv.factories.PositionDataActionFactory;
import com.project.main.io.csv.factories.TransactionDataActionFactory;
import com.project.main.io.printers.DataPrinter;
import com.project.main.io.printers.FileDataPrinter;
import com.project.main.io.printers.ResultObjectPrinter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private final static String CSV_POS_INFO_FILE = "/home/prafailov/opt/fin-app/fin-app-client/trunk/rest-client/src/main/resources/position-info.csv";
    private final static String CSV_CALC_RESULTS_FILE = "/home/prafailov/opt/fin-app/fin-app-client/trunk/rest-client/src/main/resources/calculation-results.csv";

    public static void main(String[] args) throws IOException {

        InstrumentClient icr = new InstrumentClient();
        PositionClient pcr = new PositionClient();
        TransactionClient tcr = new TransactionClient();

        InstrumentDataActionFactory idf = new InstrumentDataActionFactory();
        PositionDataActionFactory pdf = new PositionDataActionFactory();
        TransactionDataActionFactory tdf = new TransactionDataActionFactory();

        DataAction<Instrument> ida = idf.getAction();
        DataAction<Position> pda = pdf.createPositionDataAction();
        DataAction<Transaction> tda = tdf.createTransactionDataAction();

        CSVDataParser<Instrument> insParser = new CSVDataParser(ida);
        CSVDataParser<Position> posParser = new CSVDataParser(pda);
        CSVDataParser<Transaction> txParser = new CSVDataParser(tda);

        Instrument instrument = insParser.parseData();
        Instrument savedInstrument = icr.postInstrument(instrument);
        System.out.println("Saved Instrument with id: " + savedInstrument.getId());

        Position position = posParser.parseData();
        position.setInstrument(savedInstrument);
        Position savedPosition = pcr.postPosition(position);
        System.out.println("Saved Position with id: " + savedPosition.getId());

        List<Transaction> txs = txParser.parseAllData();
        List<Transaction> savedTxs = new ArrayList<>();
        for (Transaction tx : txs) {
            tx.setPosition(savedPosition);
            Transaction savedTx = tcr.postTransaction(tx);
            System.out.println("Saved Transaction with id: " + savedTx.getId());
            savedTxs.add(savedTx);
        }
        CalculationClient cl = new CalculationClient();
//        DepositResultObject dro = (DepositResultObject) cl.getResultsForDepositCalculation(15L);
        CreditResultObject cro = cl.getResultsForCreditCalculation(savedPosition.getId());

        Map<LocalDateTime, Double> cf = cro.getInterestPayments();
//        Map<LocalDateTime, Double> ip = dro.getInterestPayments();
//        res.getPrincipalPayments();
        DataPrinter posInfoPrinter = new FileDataPrinter(CSV_POS_INFO_FILE);
        DataPrinter calcResultsPrinter = new FileDataPrinter(CSV_CALC_RESULTS_FILE);
        ResultObjectPrinter croPrinter = new ResultObjectPrinter();
        
        String insType = cro.getInstrumentType();
        cro.getInterestPayments();
        Position pos = cro.getPosition();
        String positionInfo = pos.toString() + ", " + insType;
//        calcResultsPrinter.print(insType)
        System.out.println(cro.getInterestPayments().toString());

        croPrinter.printCreditResults(cro, CSV_POS_INFO_FILE);
//        croPrinter.printDepositResults(dro, positionInfo)
    }

}
