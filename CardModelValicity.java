package com.company;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardModelValicity extends CardModel{
    private Date dateBegin;
    private Date dateEnd;
    private int timeBegin;
    private int timeEnd;
    public CardModelValicity(String ID, char type, Date dateBegin, Date dateEnd, int timeBegin, int timeEnd) {
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
}
