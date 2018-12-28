package com.project.main.clients.calculationclient;

import com.project.main.clients.AbstractClient;
import com.project.main.data.results.CreditResultObject;
import com.project.main.data.results.DepositResultObject;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author prafailov
 */
public class CalculationClient extends AbstractClient {

    private final static String CALC_PATH = "/calculator";

    public CalculationClient() {

    }

    public DepositResultObject getResultsForDepositCalculation(Long posId) {
        Invocation.Builder inv = getTarget().path(CALC_PATH + "/deposit-calc/" + posId).request(MediaType.APPLICATION_JSON);
        DepositResultObject dro = inv.get(DepositResultObject.class);
        return dro;
    }

    public CreditResultObject getResultsForCreditCalculation(Long posId) {
        Invocation.Builder inv = getTarget().path(CALC_PATH + "/credit-calc/" + posId).request(MediaType.APPLICATION_JSON);
        CreditResultObject ro = inv.get(CreditResultObject.class);
        return ro;
    }

}
