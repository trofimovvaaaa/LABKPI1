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
        Date date = new Date();
        CardModel CD = registry.getCard(ID);
        registry.newPass(ID, date, CD.Pass());
    }
    public static boolean warn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Check document. Enter y if the documents are valid, n - if not.");
        char answer = sc.next().charAt(0);
        if(answer=='y'){
            return true;
        }else{ return false;}
    }
}
