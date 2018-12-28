package com.project.main.data.transactions;

/**
 *
 * @author prafailov
 */
public enum Sign {

    POSITIVE("positive", 1), NEGATIVE("negative", -1);

    private int value;
    private String type;

    Sign(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Sign valueOf(int value) {
        if (value == 1) {
            return Sign.POSITIVE;
        } else if (value == -1) {
            return Sign.NEGATIVE;
        }
        throw new NullPointerException();
    }
    
}
