package com.project.main.data.results;

import com.project.main.data.position.Position;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author prafailov
 */
public class DepositResultObject extends ResultObject {

    public DepositResultObject() {

    }

    public DepositResultObject(Map<LocalDateTime, Double> cashFlow, Position position, String instrumentType) {
        super(cashFlow, position, instrumentType);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
