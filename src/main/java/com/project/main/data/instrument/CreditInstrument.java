/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.data.instrument;

import com.project.main.data.instrument.frequency.Frequency;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author user
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditInstrument extends DebtInstrument {

    private Frequency principalFrequency;

    public CreditInstrument() {
    }

    public CreditInstrument(String instrumentName, LocalDateTime startOfPaymentPeriod, LocalDateTime endOfPaymentPeriod,
            double interestRate, Frequency principalFrequency, Frequency interestFrequency) {

        super(instrumentName, startOfPaymentPeriod, endOfPaymentPeriod, interestRate, interestFrequency);
        this.principalFrequency = principalFrequency;

    }

    public Frequency getPrincipalFrequency() {
        return principalFrequency;
    }

    public void setPrincipalFrequency(Frequency principalFrequency) {
        this.principalFrequency = principalFrequency;
    }

}
