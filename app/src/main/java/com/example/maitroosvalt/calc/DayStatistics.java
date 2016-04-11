package com.example.maitroosvalt.calc;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public class DayStatistics {
    private long id;
    private int operandId;
    private int dayStamp;
    private int dayCounter;

    public DayStatistics() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOperandId(int operandId) {
        this.operandId = operandId;
    }

    public Integer getOperandId() {
        return operandId;
    }

    public int getDayStamp() {
        return dayStamp;
    }

    public void setDayStamp(int dayStamp) {
        this.dayStamp = dayStamp;
    }

    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }
}
