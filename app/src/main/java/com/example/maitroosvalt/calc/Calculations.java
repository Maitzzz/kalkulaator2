package com.example.maitroosvalt.calc;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public class Calculations {
    private long id;
    private int operandId;
    private float num2;
    private float num1;
    private float res;
    private float timestamp;

    public Calculations() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getRes() {
        return res;
    }

    public void setRes(float res) {
        this.res = res;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public int getOperandId() {
        return operandId;
    }

    public void setOperandId(int operandId) {
        this.operandId = operandId;
    }
}
