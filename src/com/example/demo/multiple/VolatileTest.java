package com.example.demo.multiple;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest {

    static volatile int var = 0;
//    static int var = 0;
    static int size = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            a++;
            System.out.println(a);
        }
        // ===================================================
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < size; i++) {
//                var++;
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < size; i++) {
//                var++;
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        System.out.println(var);
        // ===================================================
    }
}
