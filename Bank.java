package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bank{
    private ArrayList<Account> list = new ArrayList<Account>();

    public void addAccount(){
        list.add(new Account(true, round(Math.random()*1000, 4)));
    }
    public Account getAccount(int id){
        return list.get(id);
    }

    public void transfer(Account from, Account to, double amount){
        if(from == to || from.isAvailable()==false || to.isAvailable() == false) return;
        synchronized (from){
            synchronized (to){
                if(from.getCash() - amount >=0){
                    from.setCash(from.getCash() - amount);
                    to.setCash(to.getCash() + amount);
                }
                if(from.getCash()==0){
                    from.setAvailable(false);
                }
            }
        }
    }
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
