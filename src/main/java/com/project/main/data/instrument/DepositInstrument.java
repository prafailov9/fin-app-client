package com.project.main.data.instrument;

import com.project.main.data.instrument.frequency.Frequency;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositInstrument extends DebtInstrument {

    public DepositInstrument() {
    }

    public DepositInstrument(String instrumentName, LocalDateTime startOfPaymentPeriod,
            LocalDateTime endOfPaymentPeriod, double interestRate, Frequency interestFrequency) {
        super(instrumentName, startOfPaymentPeriod, endOfPaymentPeriod, interestRate, interestFrequency);
    }

}
