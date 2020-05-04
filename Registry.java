package com.company;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Registry{
    private ArrayList<CardModelLifts> cardModelLifts= new ArrayList<CardModelLifts>();
    private ArrayList<CardModelValicity> cardModelValicities = new ArrayList<CardModelValicity>();
    private ArrayList<Pass> passes=new ArrayList<Pass>();

    public void issueCard() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter type of card (l-lifts, v-valicity) ");
        char type =  in.next().charAt(0);
        Random ran = new Random();
        if(type=='l'){
            String ID = "1"+ran.nextInt(1000);
            System.out.println("Please enter type of card (s-simple, p-preferential, v-VIP) ");
            Scanner scanner1= new Scanner(System.in);
            char types = scanner1.next().charAt(0);
            System.out.println("Please enter count of lifts: ");
            Scanner scanner= new Scanner(System.in);
            int count = scanner.nextInt();
            issueCardLifts(ID, types, count);
            System.out.println("Id of issued card is " + ID);
        }
        if(type=='v'){
            String ID = "2"+ran.nextInt(1000);
            System.out.println("Please enter type of card (s-simple, p-preferential, v-VIP) ");
            Scanner scanner1= new Scanner(System.in);
            char types = scanner1.next().charAt(0);
            System.out.println("Please enter date from and to(Format: \n dd-MMM-yyyy \n dd-MMM-yyyy ");
            Scanner scanner = new Scanner(System.in);
            Date dateBegin = null;
            Date dateEnd = null;
            try {
                dateBegin = formatter.parse(scanner.nextLine());
                dateEnd = formatter.parse(scanner.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Please enter time from and to(Format: hh  hh) ");
            Scanner scanne1 = new Scanner(System.in);
            int timeBegin=scanne1.nextInt();
            int timeEnd=scanne1.nextInt();
            issueCardValicity(ID, types, dateBegin, dateEnd, timeBegin, timeEnd);
            System.out.println("Id of issued card is " + ID);
        }
    }
    public void issueCardValicity(String ID, char type, Date dateB, Date dateE, int timeB, int timeE){
        cardModelValicities.add(new CardModelValicity(ID, type, dateB, dateE, timeB, timeE));
    }
    public void issueCardLifts(String ID, char type, int count){
        cardModelLifts.add(new CardModelLifts(ID, type, count));
    }
    public void newPass(String ID, Date date, boolean pass){
        passes.add(new Pass(ID, date, pass));
    }

    public void getInformation(){
        Scanner in= new Scanner(System.in);
        System.out.println("Please enter ID of card: ");
        String ID = in.nextLine();
        if(ID.startsWith("1")){
            getInformationLifts(ID);
        }
        if(ID.startsWith("2")){
            getInformationValicity(ID);
        }
    }
    public void getInformationValicity(String ID) {
        for (CardModelValicity card : cardModelValicities) {
            if (card.getID().equals(ID)) {
                System.out.println("ID of card: " + card.getID()+ ". Type of card:  "+ card.getType() +
                        ". Date from " + card.getDateBegin()+ " to "+ card.getDateEnd()+
                        ". Time from " + card.getTimeBegin()+ " to "+ card.getTimeEnd());;
            }
        }
    }
    public void getInformationLifts(String ID){
        for (CardModelLifts card : cardModelLifts) {
            if (card.getID().equals(ID)) {
                System.out.println("ID of card: " + card.getID() + ". Type of card:  "+ card.getType() +
                        ". Passes avaliable: " + card.getCount());
            }
        }
    }
    public void getInformationPasses(){
        Scanner in= new Scanner(System.in);
        System.out.println("Please enter ID of card: ");
        String ID = in.nextLine();
        for (Pass pass : passes) {
            if (pass.getID().equals(ID)) {
                System.out.println("ID of card: " + pass.getID()+ ". Passes date:  "+ pass.getDate() +
                        ". Enter successful " + pass.isPass());
            }
        }
    }
    public void block(){
        Scanner in= new Scanner(System.in);
        System.out.println("Please enter ID of card: ");
        String ID = in.nextLine();
        if(ID.startsWith("1")){
            for (CardModelLifts card : cardModelLifts) {
            if (card.getID().equals(ID)) {
                card.setType('B');
                System.out.println("ID of card: " + card.getID() + ". Type of card:  "+ card.getType() +
                        ". Passes avaliable: " + card.getCount());
            }
        }
        }
        if(ID.startsWith("2")){
            for (CardModelValicity card : cardModelValicities) {
                if (card.getID().equals(ID)) {
                    card.setType('B');
                    System.out.println("ID of card: " + card.getID()+ ". Type of card:  "+ card.getType() +
                            ". Date from " + card.getDateBegin()+ " to "+ card.getDateEnd() +
                            ". Time from " + card.getTimeBegin()+ " to "+ card.getTimeEnd());
                }
            }
        }
    }
    public CardModelLifts existCardL(String ID){
        for (CardModelLifts card : cardModelLifts) {
            if (card.getID().equals(ID)) {
                return card;
            }
        }
        return null;
    }
    public CardModelValicity existCardV(String ID){
        for (CardModelValicity card : cardModelValicities) {
            if (card.getID().equals(ID)) {
                return card;
            }
        }
        return null;
    }
}
