package com.project.main.data.results;

import com.project.main.data.position.Position;
import com.project.main.io.adapters.JsonMapAdapter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author prafailov
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({CreditResultObject.class, DepositResultObject.class})
public abstract class ResultObject {

    @XmlElement(name = "interestPayments")
    @XmlJavaTypeAdapter(JsonMapAdapter.class)
    private Map<LocalDateTime, Double> interestPayments;

    private Position position;
    private String instrumentType;

    public ResultObject() {

    }

    public ResultObject(Map<LocalDateTime, Double> interestPayments, Position position, String insType) {
        this.interestPayments = interestPayments;
        this.position = position;
        this.instrumentType = insType;
    }

    public ResultObject(Map<LocalDateTime, Double> interestPayments) {
        this.interestPayments = interestPayments;
    }

    public Map<LocalDateTime, Double> getInterestPayments() {
        return interestPayments;
    }

    public void setInterestPayments(Map<LocalDateTime, Double> interestPayments) {
        this.interestPayments = interestPayments;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.interestPayments);
        hash = 89 * hash + Objects.hashCode(this.position);
        hash = 89 * hash + Objects.hashCode(this.instrumentType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultObject other = (ResultObject) obj;
        if (!Objects.equals(this.instrumentType, other.instrumentType)) {
            return false;
        }
        if (!Objects.equals(this.interestPayments, other.interestPayments)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return interestPayments + ", " + position + ", " + instrumentType;
    }

}
