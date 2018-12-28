package com.project.main.data.results;

import java.time.LocalDateTime;

/**
 *
 * @author prafailov
 */
public class ResultMapPair {

    private LocalDateTime key;
    private Double value;

    public ResultMapPair() {

    }

    public ResultMapPair(LocalDateTime key, Double value) {
        this.key = key;
        this.value = value;

    }

    public LocalDateTime getKey() {
        return key;
    }

    public void setKey(LocalDateTime key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ", " + value;
    }

}
