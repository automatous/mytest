package com.example.demo.syntax;

import org.junit.Test;

public class Global8LocalVariableTest {

    static int globalVar;

    public static void main(String[] args) {
//        static int localVar;    // modifier 'static' not allowed here
        int pc = 0x3000;
        int sevenBits = 0xA1234;
        int valueD = 0xD;
//        int overflow = 0x123456789; // integer number too large
        System.out.println(pc);
        System.out.println(sevenBits);
        System.out.println(valueD);
//        System.out.println(overflow);
        int x = 4;
        int y = (x = x + 1);
        System.out.println(y);
        System.out.println(x);
    }

    // ===================================================

    @Test
    public void piTest() {
        double pi;
        pi = pi(0L);
        System.out.println(pi);
        for (long i = 1; i > 0L; i *= 10) {
            /**
             * 4.0
             * 2.666666666666667
             * 3.232315809405594
             * 3.1514934010709914
             * 3.1425916543395442
             * 3.1416926435905346
             * 3.1416026534897203
             * 3.1415936535887745
             * 3.1415927535897814
             * 3.141592663589326
             * 3.1415926545880506
             * 3.141592653688346
             * 3.141592653598537
             * 越到后面越久, 此时已经快10几分钟了, 下一个估计要几个小时了....
             * 基本规律, 从左到右, 精度一位一位的计算
             * 3.1415926535(第10位有效精度位, 计算下一位的精度就是第11位了)
             * 虽然可以用动态规划少算一点, 但无实质提升!!!!
             * 算法复杂度还是一样高!!
             */
            pi = pi(i);
            System.out.println(pi);
        }

        // 3.1415926535897932384626433832795
        // 3.141592663589326
//        pi = pi(100000000L);
//        System.out.println(pi);
    }

    public static double pi(long precision) {
        double sum = 0;

        long divisor;
        for (long i = 0; i <= precision; i++) {
            divisor = i % 2 == 0 ? (2 * i + 1) : -(2 * i + 1);
            sum += 4.0 / divisor;
        }
        return sum;
    }
    // ===================================================

    @Test
    public void forFor() {
        int sum = 0;
        int input = 4;
        int inner;
        int outer;
        for (outer = 1; outer <= input; outer++) {
            for (inner = 0; inner < outer; inner++) {
                System.out.print(inner + "\t");
                sum += inner;
            }
            System.out.println();
        }
        System.out.println("sum = " + sum);
    }

    @Test
    public void testMultiply() {
        int multiplicand;
        int multiplier;
        for (multiplicand = 0; multiplicand < 10; multiplicand++) {
            for (multiplier = 0; multiplier < 10; multiplier++) {
                System.out.print(multiplicand * multiplier + "\t");
            }
            System.out.println();
        }
    }
    // ===================================================

    @Test
    public void testBar() {
//        bar();
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        char letter = 'a';
        for (int i = 0; i < 26; i++) {
            System.out.print((char) (letter + i) + " ");
        }
        System.out.println();

        int inputValue = 7;
        int numberOfOnes = 0;
        for (int i = 0; i < 32; i++) {
            if ((inputValue & (1 << i)) != 0) {
                numberOfOnes++;
            }
        }
        System.out.println(numberOfOnes);

        numberOfOnes = 0;
        while (inputValue != 0) {
            numberOfOnes++;
            inputValue = inputValue & (inputValue - 1);
        }
        System.out.println(numberOfOnes);
    }

    public static void bar() {
        for (; ; ) {
            System.out.println("hello bar....");
        }
    }

    // ===================================================


    @Test
    public void testFoo() {
        foo(3, 5);
    }

    public static void foo(int x, int y) {
        int z = 0;
        int w = 0;
//        if (x == 3) {
//            if (y != 6) {
//                z = z + 1;
//                w = w + 2;
//            }
//        }

        if (x == 3 && y != 6) {
            z = z + 1;
            w = w + 2;
        }
        System.out.println(z);
        System.out.println(w);
    }
    // ===================================================


}
