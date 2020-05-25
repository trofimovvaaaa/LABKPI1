package com.company;

public class Account{
    private boolean available;
    private double cash;

    public Account(boolean available, double cash) {
        this.available = available;
        this.cash = cash;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
