/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.clients.transactionclient;

import com.project.main.clients.AbstractClient;
import com.project.main.data.transactions.Transaction;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author user
 */
public class TransactionClient extends AbstractClient {

    private final static String BASE_TRANSACTION_PATH = "transactions";

    public Transaction getTransaction(Long id) {

        Invocation.Builder inv = getTarget().path(BASE_TRANSACTION_PATH + "/" + id).request(MediaType.APPLICATION_JSON);
        Transaction receivedTx = inv.get(Transaction.class);
        return receivedTx;
    }

    public List<Transaction> getAllTransactions() {

        Invocation.Builder inv = getTarget().path(BASE_TRANSACTION_PATH + "/all").request(MediaType.APPLICATION_JSON);
        List<Transaction> txs = inv.get(new GenericType<List<Transaction>>() {
        });
        return txs;
    }

    public Transaction postTransaction(Transaction tx) {
        Invocation.Builder inv = getTarget().path(BASE_TRANSACTION_PATH + "/add").request(MediaType.APPLICATION_JSON);
        Transaction receivedTx = inv.post(Entity.entity(tx, MediaType.APPLICATION_JSON), Transaction.class);
        return receivedTx;
    }

    public Transaction deleteTransaction(Long id) {
        Invocation.Builder inv = getTarget().path(BASE_TRANSACTION_PATH + "/delete/" + id).request(MediaType.APPLICATION_JSON);
        Transaction deletedTx = inv.delete(Transaction.class);
        return deletedTx;
    }

    public Transaction updateTransaction(Transaction tx) {
        Invocation.Builder inv = getTarget().path(BASE_TRANSACTION_PATH + "/update").request(MediaType.APPLICATION_JSON);
        Transaction updatedTx = inv.post(Entity.entity(tx, MediaType.APPLICATION_JSON), new GenericType<Transaction>() {
        });
        return updatedTx;
    }

}
