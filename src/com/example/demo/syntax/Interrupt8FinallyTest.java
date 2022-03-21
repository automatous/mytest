package com.example.demo.syntax;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class Interrupt8FinallyTest {

    public static void main(String[] args) {
        System.out.println("main start....");

        Thread t = new Thread(() -> {
            boolean failed = true;
            try {
                for (; ; ) {
                    System.out.println("thread before park....");
                    LockSupport.park();
                    System.out.println("thread after park....");
                    failed = false;
                    return;
                }
            } finally {
                if (failed) {
                    System.out.println("thread failed is true....");
                }
            }
        });
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
        System.out.println("main after interrupt....");
    }

}
