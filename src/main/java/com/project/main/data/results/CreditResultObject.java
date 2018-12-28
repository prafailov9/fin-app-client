package com.project.main.data.results;

import com.project.main.data.position.Position;
import com.project.main.io.adapters.JsonMapAdapter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author prafailov
 */
public class CreditResultObject extends ResultObject {

    @XmlElement(name = "principalPayments")
    @XmlJavaTypeAdapter(JsonMapAdapter.class)
    private Map<LocalDateTime, Double> principalPayments;

    public CreditResultObject() {

    }

    public CreditResultObject(Map<LocalDateTime, Double> cashFlow, Position position, String instrumentType,
            Map<LocalDateTime, Double> principalPayments) {
        super(cashFlow, position, instrumentType);
        this.principalPayments = principalPayments;
    }

    public Map<LocalDateTime, Double> getPrincipalPayments() {
        return principalPayments;
    }

    public void setPrincipalPayments(Map<LocalDateTime, Double> principalPayments) {
        this.principalPayments = principalPayments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.principalPayments);
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
        final CreditResultObject other = (CreditResultObject) obj;
        if (!Objects.equals(this.principalPayments, other.principalPayments)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "principalPayments=" + principalPayments;
    }

}
