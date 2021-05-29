package com.example.demo.alg;

public class OnesPositionTest {
    public static void main(String[] args) {
        int i = onesPosition(-1);
        int j = onesPosition(0);
        int k = onesPosition(1);
        int x = onesPosition(16);
        int y = onesPosition(Integer.MAX_VALUE);
        int z = onesPosition(Integer.MIN_VALUE);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static int onesPosition(int i) {
        int p = 31;
        if (i == 0) {
            p = p - 32;
        } else {
            while (i > 0) {
                i = i + i;
                p--;
            }
        }
        return p;
    }
}
