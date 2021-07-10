package com.example.demo.approach;

import com.example.demo.stdio.StdIn;
import com.example.demo.stdio.StdOut;

public class StdInTest {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int value = StdIn.readInt();
            sum += value;
        }
        StdOut.println("Sum is " + sum);
    }
}
