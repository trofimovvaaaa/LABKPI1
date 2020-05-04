package com.company;

public abstract class CardModel{
    private String ID;
    private char type;

    public CardModel(String ID, char type){
        this.ID=ID;
        this.type=type;
    }
    public char getType() {
        return type;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setType(char type) {
        this.type = type;
    }
}
