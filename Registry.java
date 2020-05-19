package com.company;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Registry{
    private HashMap<String, CardModel> cardModels= new HashMap<>();
    private ArrayList<Pass> passes=new ArrayList<Pass>();

    public void issueCard() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Scanner in = new Scanner(System.in);
        Random ran = new Random();
        String ID = "" + ran.nextInt(1000);
        Type t = Type.BLOCKED;
        System.out.println("Please enter type of card (s-simple, p-preferential, v-VIP) ");
        Scanner scanner1 = new Scanner(System.in);
        char types = scanner1.next().charAt(0);
        switch (types) {
            case 's':
                t = Type.SIMPLE;
                break;
            case 'p':
                t = Type.PREFERENTIAL;
                break;
            case 'v':
                t = Type.VIP;
                break;
            default:
                System.out.println("Please enter correct value");
        }
        System.out.println("Please enter type of card (l-lifts, v-valicity)");
        char type = in.next().charAt(0);
        switch (type) {
            case 'l':
                System.out.println("Please enter count of lifts: ");
                Scanner scanner = new Scanner(System.in);
                int count = scanner.nextInt();
                issueCardLifts(ID, t, count);
                System.out.println("Id of issued card is " + ID);
                break;
            case 'v':
                System.out.println("Please enter date from and to(Format: \n dd-MMM-yyyy \n dd-MMM-yyyy ");
                Scanner sc = new Scanner(System.in);
                Date dateBegin = null;
                Date dateEnd = null;
                dateBegin = formatter.parse(sc.nextLine());
                dateEnd = formatter.parse(sc.nextLine());
                System.out.println("Please enter time from and to(Format: hh  hh) ");
                Scanner scanne1 = new Scanner(System.in);
                int timeBegin = scanne1.nextInt();
                int timeEnd = scanne1.nextInt();
                issueCardValicity(ID, t, dateBegin, dateEnd, timeBegin, timeEnd);
                System.out.println("Id of issued card is " + ID);
                break;
            default:
                System.out.println("please enter correct value");
        }
    }
    public void issueCardValicity(String ID, Type type, Date dateB, Date dateE, int timeB, int timeE){
        cardModels.put(ID, new CardModelValicity(ID, type, dateB, dateE, timeB, timeE));
    }
    public void issueCardLifts(String ID, Type type, int count){
        cardModels.put(ID, new CardModelLifts(ID, type, count));
    }
    public void newPass(String ID, Date date, boolean pass){
        passes.add(new Pass(ID, date, pass));
    }

    public void getInformation(){
        Scanner in= new Scanner(System.in);
        System.out.println("Please enter ID of card: ");
        String ID = in.nextLine();
        CardModel CD = cardModels.get(ID);
        CD.Information();
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
        CardModel CD = cardModels.get(ID);
        CD.setType(Type.BLOCKED);
        CD.Information();
    }
    public CardModel getCard(String ID){
        return cardModels.get(ID);
    }
}
