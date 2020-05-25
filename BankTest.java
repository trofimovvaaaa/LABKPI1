package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @org.junit.jupiter.api.Test
    void transfer() throws InterruptedException {
        double expected = 0;
        Bank bank = new Bank();
        for(int i = 0; i < 100; i++){
            bank.addAccount();
            expected+=bank.getAccount(i).getCash();
        }
        Thread[] threads = new Thread[5000];
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
        double actual = 0;
        for(int i = 0; i < 100; i++){
            actual+=bank.getAccount(i).getCash();
        }
        assertEquals(bank.round(expected,4), bank.round(actual,4));
    }
}