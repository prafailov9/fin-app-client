/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.io.csv.actions;

import com.project.main.data.transactions.Sign;
import com.project.main.data.transactions.Transaction;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 */
public class TransactionDataAction extends DataAction<Transaction> {

    public TransactionDataAction(String filePath, Reader reader, CSVParser parser, List<CSVRecord> records) {
        super(filePath, reader, parser, records);
    }

    @Override
    public Transaction parseLine() {
        Transaction tx = new Transaction();
        List<CSVRecord> records = getRecords();
        for (CSVRecord record : records) {
            tx = getSingleRecord(record);
        }
        return tx;
    }

    @Override
    public List<Transaction> parseAll() {
        List<Transaction> txs = new ArrayList<>();
        List<CSVRecord> records = getRecords();
        for (CSVRecord record : records) {
            txs.add(getSingleRecord(record));
        }
        return txs;
    }

    private Transaction getSingleRecord(CSVRecord record) {
        Transaction tx = new Transaction();
        tx.setTransactionDate(LocalDateTime.parse(record.get("txDate"), getDTF()));
        tx.setAmount(Double.parseDouble(record.get("amount")));
        tx.setSign(Sign.valueOf(Integer.parseInt(record.get("sign"))));
        return tx;
    }

}
