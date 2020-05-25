package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int n = 8;
        long iterations = 1000000;
        long startTime, finishTime;
        startTime = System.currentTimeMillis();
        System.out.println("Pi is " + getPi(n, iterations));
        System.out.println("Threads " + n);
        System.out.println("Interactions " + iterations);
        System.out.println("Time " + (System.currentTimeMillis() - startTime) + "ms");
    }
    public static double getPi(int n, long iterations) throws InterruptedException {
        long passedTotal = 0, iterationsPerProcess = iterations / n;
        MyThread[] threads = new MyThread[n];
        for(int i = 0; i < n; i++) {
            threads[i] = new MyThread(iterationsPerProcess);
            threads[i].start();
            threads[i].join();
            passedTotal += threads[i].passed;
        }
        return ((double) passedTotal / iterations) * 4.0;
    }
}
