package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Turnstile{
    public void pass(Registry registry){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ID");
        String ID = in.nextLine();
        CardModelLifts cml = null;
        CardModelValicity cmv =null;
        Date date = new Date();
        if(ID.startsWith("1")){
            cml=registry.existCardL(ID);
            if(cml.getCount()>0 && cml.getType()!='p'&& cml.getType()!='B'){
                System.out.println("Passage allowed!");
                cml.setCount(cml.getCount()-1);
                registry.newPass(cml.getID(), date, true);
            }else{
                if(cml.getType()=='B'){
                    System.out.println("Card is blocked. Passes are not available");
                    registry.newPass(cml.getID(), date, false);
                }else{
                    if(cml.getCount()>0 && cml.getType()=='p' && warn()){
                        System.out.println("Passage allowed!");
                        cml.setCount(cml.getCount()-1);
                        registry.newPass(cml.getID(), date, true);
                    }else{
                        System.out.println("Passes are not available");
                        registry.newPass(cml.getID(), date, false);
                    }
                }
            }
        }else{
            if(ID.startsWith("2")){
                cmv = registry.existCardV(ID);
                if(date.compareTo(cmv.getDateBegin())>0 && date.compareTo(cmv.getDateEnd())<0 && date.getHours()>cmv.getTimeBegin()&& date.getHours()<cmv.getTimeEnd()&& cmv.getType()!='p'&& cmv.getType()!='B'){
                    System.out.println("Passage allowed!");
                    registry.newPass(cmv.getID(), date, true);
                }else{
                    if(cmv.getType()=='B'){
                        System.out.println("Card is blocked. Passes are not available");
                        registry.newPass(cmv.getID(), date, false);
                    }else{
                        if(date.compareTo(cmv.getDateBegin())>0 && date.compareTo(cmv.getDateEnd())<0 && date.getHours()>cmv.getTimeBegin()&& date.getHours()<cmv.getTimeEnd()&&cmv.getType()=='p' && warn()){
                            System.out.println("Passage allowed!");
                            registry.newPass(cmv.getID(), date, true);
                        }else{
                            System.out.println("Passes are not available");
                            registry.newPass(cmv.getID(), date, false);
                        }
                    }
                }
            }
        }
    }
    private boolean warn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Check document. Enter y if the documents are valid, n - if not.");
        char answer = sc.next().charAt(0);
        if(answer=='y'){
            return true;
        }else{ return false;}
    }
}
