package com.company;

public abstract class CardModel{
    private String ID;
    private Type type;

    public CardModel(String ID, Type type){
        this.ID=ID;
        this.type=type;
    }
    public Type getType() {
        return type;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void Information(){}
    public boolean Pass(){ return true;}
}
enum Type{
    VIP,
    SIMPLE,
    PREFERENTIAL,
    BLOCKED
}
