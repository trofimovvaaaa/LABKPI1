package com.company;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardModelValicity extends CardModel{
    private Date dateBegin;
    private Date dateEnd;
    private int timeBegin;
    private int timeEnd;
    public CardModelValicity(String ID, Type type, Date dateBegin, Date dateEnd, int timeBegin, int timeEnd) {
        super(ID, type);
        this.dateBegin=dateBegin;
        this.dateEnd=dateEnd;
        this.timeBegin=timeBegin;
        this.timeEnd=timeEnd;
    }

    public Date getDateBegin() { return dateBegin; }

    public Date getDateEnd() {
        return dateEnd;
    }

    public int getTimeBegin() { return timeBegin; }

    public int getTimeEnd() { return timeEnd; }

    public void setTimeBegin(int timeBegin) {
        this.timeBegin = timeBegin;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public void Information() {
        System.out.println("ID of card: " + getID()+ ". Type of card:  "+ getType() +
                ". Date from " + getDateBegin()+ " to "+ getDateEnd()+
                ". Time from " + getTimeBegin()+ " to "+ getTimeEnd());
    }

    @Override
    public boolean Pass() {
        Date date = new Date();
        if(date.compareTo(getDateBegin())>0 && date.compareTo(getDateEnd())<0 && date.getHours()>getTimeBegin()&& date.getHours()<getTimeEnd()&& getType()!=Type.PREFERENTIAL&& getType()!=Type.BLOCKED){
            System.out.println("Passage allowed!");
            return true;
        }else{
            if(getType()==Type.BLOCKED){
                System.out.println("Card is blocked. Passes are not available");
                return false;
            }else{
                if(date.compareTo(getDateBegin())>0 && date.compareTo(getDateEnd())<0 && date.getHours()>getTimeBegin()&& date.getHours()<getTimeEnd()&&getType()==Type.PREFERENTIAL && Turnstile.warn()){
                    System.out.println("Passage allowed!");
                    return true;
                }else{
                    System.out.println("Passes are not available");
                    return false;
                }
            }
        }
    }
}
