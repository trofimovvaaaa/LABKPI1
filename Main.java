package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        double allCash = 0;
        Bank bank = new Bank();
        for(int i = 0; i < 100; i++){
            bank.addAccount();
            allCash+=bank.getAccount(i).getCash();
        }
        Thread[] threads = new Thread[1000];
        for(int i = 1; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    bank.transfer(bank.getAccount((int)(Math.random() * 100)), bank.getAccount((int)(Math.random() * 100)), 1 + bank.round(Math.random() * 200, 4));
                }
            });
            threads[i].start();
            threads[i].join();
        }
        double actualSum = 0;
        for(int i = 0; i < 100; i++){
            actualSum+=bank.getAccount(i).getCash();
        }
        System.out.println(""+actualSum +'\n' + allCash);
    }
}
