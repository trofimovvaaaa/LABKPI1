package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Registry registry = new Registry();
        registry.issueCardLifts("111", 's', 4);
        registry.issueCardLifts("112", 'p', 7);
        registry.issueCardLifts("113", 'v', 9);
        try {
            registry.issueCardValicity("211", 's', formatter.parse("02-May-2020"), formatter.parse("02-Jun-2020"), 9, 14);
            registry.issueCardValicity("212", 'p', formatter.parse("01-Sep-2019"), formatter.parse("01-Sep-2020"), 14, 19);
            registry.issueCardValicity("213", 'v', formatter.parse("02-May-2020"), formatter.parse("02-Jun-2020"), 9, 23);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        while(true){
            System.out.println("Hello! \n Please choose what you want to do: \n"+
                    "1.Issue new card \n"+
                    "2.Get information about card\n"+
                    "3.Get information about passes\n"+
                    "4.Block card\n"+
                    "5.New pass\n"+
                    "Please enter number: ");
            Scanner in=new Scanner(System.in);
            int choose = in.nextInt();
            switch (choose) {
                case 1:
                    registry.issueCard();
                    break;
                case 2:
                    registry.getInformation();
                    break;
                case 3:
                    registry.getInformationPasses();
                    break;
                case 4:
                    registry.block();
                    break;
                case 5:
                    Turnstile turnstile=new Turnstile();
                    turnstile.pass(registry);
                    break;
                default:
                    System.out.println("Please enter correct number!");
            }

        }
    }
}

