/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.data.instrument;

import com.project.main.io.adapters.LocalDateTimeAdapter;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author user
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({CreditInstrument.class, DepositInstrument.class, Share.class})
public abstract class Instrument {

    private Long id;

    private String instrumentName;

    @XmlElement(name = "startOfPaymentPeriod")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime startOfPaymentPeriod;

    @XmlElement(name = "endOfPaymentPeriod")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime endOfPaymentPeriod;

    public Instrument() {

    }

    Instrument(String instrumentName, LocalDateTime startOfPaymentPeriod, LocalDateTime endOfPaymentPeriod) {
        this.instrumentName = instrumentName;
        this.startOfPaymentPeriod = startOfPaymentPeriod;
        this.endOfPaymentPeriod = endOfPaymentPeriod;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String name) {
        instrumentName = name;
    }
    
    public LocalDateTime getStartOfPaymentPeriod() {
        return startOfPaymentPeriod;
    }

    public void setStartOfPaymentPeriod(LocalDateTime ldt) {
        startOfPaymentPeriod = ldt;
    }
    
    public LocalDateTime getEndOfPaymentPeriod() {
        return endOfPaymentPeriod;
    }

    public void setEndOfPaymentPeriod(LocalDateTime ldt) {
        endOfPaymentPeriod = ldt;
    }
    
}
