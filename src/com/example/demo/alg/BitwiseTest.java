package com.example.demo.alg;


import org.junit.jupiter.api.Test;

public class BitwiseTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 100;
        float f = 1.0f;
//        i = i << 33;
//        i = i >> 33;
        i = i << j;
        i = i >> j;
        j = (int) (i + f);
    }


    @Test
    public void testPrintBinary() {
        printBinary(19);
    }

    public static void printBinary(int n) {
        int power = 1;
        while (power <= n / 2) {
            power = 2 * power;
        }

        while (power > 0) {
            if (n < power) {
                System.out.print(0);
            } else {
                System.out.print(1);
                n -= power;
            }
            power /= 2;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
    }
}
