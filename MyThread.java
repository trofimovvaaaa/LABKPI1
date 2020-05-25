package com.company;

import java.util.Random;

public class MyThread extends Thread {
    public long passed;
    private long iterations;

    public MyThread(long iterations) {
        this.iterations = iterations;
    }

    public void run() {
        double x;
        double y;
        passed = 0;
        for(int i = 0; i < iterations; i++) {
            x = Math.random();
            y = Math.random();
            if((Math.pow(x, 2) + Math.pow(y, 2)) < 1.0)
                passed++;
        }
    }
}
