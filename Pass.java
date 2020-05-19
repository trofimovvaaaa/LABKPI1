package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pass{
    private String ID;
    private Date date;
    private boolean pass;

    public Pass(String id, Date date, boolean pass) {
        ID = id;
        this.date = date;
        this.pass = pass;
    }

    public String getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }
    public boolean isPass() {
        return pass;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }
}
