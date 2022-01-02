package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdIn;
import com.example.demo.stdio.StdOut;

public class RangeFilter {
    public static void main(String[] args) {
        int lo = Integer.parseInt(args[0]);
        int hi = Integer.parseInt(args[1]);
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value >= lo && value <= hi) {
                StdOut.print(value + " ");
            }
            StdOut.println();
        }
    }
}
