package com.project.main.io.printers;

import com.project.main.data.results.CreditResultObject;
import com.project.main.data.results.DepositResultObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prafailov
 */
public class ResultObjectPrinter {

    private BufferedWriter writer;
    private final static String MAP_RESULTS = "%s, %s \n";
    private final static String CALC_RESULTS = "%s \n %s \n %s";

    public boolean printCreditResults(CreditResultObject cro, final String destination) {
        boolean success = false;
        try {
            writer = createWriter(destination);
            String intPayments = "Interest payments: \n" + mapToString(cro.getInterestPayments());
            String prPayments = "Principal payments: \n" + mapToString(cro.getPrincipalPayments());

            String positionInfo = "Position info: \n" + cro.getPosition().toString();
            String calcResults = String.format(CALC_RESULTS, intPayments, prPayments, positionInfo);
            writer.write(calcResults);
            writer.close();
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(ResultObjectPrinter.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        } finally {
            return success;
        }
    }

    public boolean printDepositResults(DepositResultObject dro, final String destination) {
        boolean success = false;
        try {
            writer = createWriter(destination);
            String intPayments = "Interest payments: \n" + mapToString(dro.getInterestPayments());
            String posInfo = "Position info: \n" + dro.getPosition().toString();
            String calcResults = String.format(CALC_RESULTS, intPayments, posInfo, "");

            writer.write(calcResults);
            writer.close();
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(ResultObjectPrinter.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        } finally {
            return success;
        }
    }

    private String mapToString(Map<LocalDateTime, Double> map) {
        StringBuilder appender = new StringBuilder();
        map.entrySet().forEach((entry) -> {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            appender.append(String.format(MAP_RESULTS, key, value));
        });
        return appender.toString();
    }

    private BufferedWriter createWriter(final String destination) throws IOException {
        if (Objects.isNull(destination)) {
            throw new NullPointerException();
        }
        return new BufferedWriter(new FileWriter(destination));
    }
}
