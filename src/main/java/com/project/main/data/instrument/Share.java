/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.data.instrument;

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
public class Share extends Instrument {

    public Share() {
        
    }
    
    public Share(String instrumentName, LocalDateTime startOfPaymentPeriod, LocalDateTime endOfPaymentPeriod) {
        super(instrumentName, startOfPaymentPeriod, endOfPaymentPeriod);
    }

}
