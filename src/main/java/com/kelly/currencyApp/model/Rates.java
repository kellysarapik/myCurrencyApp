package com.kelly.currencyApp.model;

public class Rates {
    private int id;
    private String currency;
    private double eurRate;


    public Rates(int id, String currency, double eurRate) {
        this.id = id;
        this.currency = currency;
        this.eurRate = eurRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getEurRate() {
        return eurRate;
    }

    public void setEurRate(double eurRate) {
        this.eurRate = eurRate;
    }
}

