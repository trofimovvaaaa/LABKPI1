package com.company;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getPi() throws InterruptedException {
        int n = 8;
        long interactions = 1000000000;
        double expected = 3.14;
        double actual= round(new Main().getPi(n, interactions),2) ;
        assertEquals(expected, actual);
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}