package com.company;

public class CardModelLifts extends CardModel{
    private int count;
    public CardModelLifts(String ID, char type, int count) {
        super(ID, type);
        this.count=count;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
