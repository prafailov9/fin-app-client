package com.project.main.data.position;

import com.project.main.io.adapters.LocalDateTimeAdapter;
import com.project.main.data.instrument.Instrument;
import com.project.main.data.transactions.Transaction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author user
 */
public class Position {

    private Long id;

    @XmlElement(name = "startingDateOfDeal")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime startingDateOfDeal;

    private String payer;

    private String receiver;

    private double principal;

    private double positionVolume;

    private Instrument instrument;
    private List<Transaction> transactions;

    public Position() {
        super();
    }

    public Position(LocalDateTime startingDateOfDeal, String payer, String receiver, Instrument instrument,
            double principal, double positionVolume) {
        super();
        this.startingDateOfDeal = startingDateOfDeal;
        this.payer = payer;
        this.receiver = receiver;
        this.instrument = instrument;
        this.principal = principal;
        this.positionVolume = positionVolume;
    }

    public LocalDateTime getStartingDateOfDeal() {
        return startingDateOfDeal;
    }

    public String getPayer() {
        return payer;
    }

    public String getReceiver() {
        return receiver;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setStartingDateOfDeal(LocalDateTime startingDateOfDeal) {
        this.startingDateOfDeal = startingDateOfDeal;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getPositionVolume() {
        return positionVolume;
    }

    public void setPositionVolume(double positionVolume) {
        this.positionVolume = positionVolume;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.startingDateOfDeal);
        hash = 17 * hash + Objects.hashCode(this.payer);
        hash = 17 * hash + Objects.hashCode(this.receiver);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.principal) ^ (Double.doubleToLongBits(this.principal) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.instrument);
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
        final Position other = (Position) obj;
        if (Double.doubleToLongBits(this.principal) != Double.doubleToLongBits(other.principal)) {
            return false;
        }
        if (!Objects.equals(this.payer, other.payer)) {
            return false;
        }
        if (!Objects.equals(this.receiver, other.receiver)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.startingDateOfDeal, other.startingDateOfDeal)) {
            return false;
        }
        if (!Objects.equals(this.instrument, other.instrument)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + ", " + startingDateOfDeal + ", " + payer + ", " + receiver
                + ", " + principal + ", " + positionVolume;
    }

}
