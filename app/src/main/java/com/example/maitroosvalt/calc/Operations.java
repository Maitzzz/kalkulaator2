package com.example.maitroosvalt.calc;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public class Operations {
    private long id;
    private String operand;
    private int lifetimeCounter;

    public Operations() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }

    public int getLifetimeCounter() {
        return lifetimeCounter;
    }

    public void setLifetimeCounter(int lifetimeCounter) {
        this.lifetimeCounter = lifetimeCounter;
    }
}
