package com.company;

public class CardModelLifts extends CardModel{
    private int count;
    public CardModelLifts(String ID, Type type, int count) {
        super(ID, type);
        this.count=count;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void Information() {
        System.out.println("ID of card: " + getID() + ". Type of card:  "+ getType() +
                ". Passes avaliable: " + getCount());
    }

    @Override
    public boolean Pass() {
        if(getCount()>0 && getType()!=Type.PREFERENTIAL && getType()!= Type.BLOCKED){
            System.out.println("Passage allowed!");
            setCount(getCount()-1);
            return true;
        }else{
            if(getType()!= Type.BLOCKED){
                System.out.println("Card is blocked. Passes are not available");
                return false;
            }else{
                if(getCount()>0 && getType()==Type.PREFERENTIAL && Turnstile.warn()){
                    System.out.println("Passage allowed!");
                    setCount(getCount()-1);
                    return true;
                }else{
                    System.out.println("Passes are not available");
                    return false;
                }
            }
        }
    }
}
