package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdIn;
import com.example.demo.stdio.StdOut;

public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int n = 0;
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            n++;
        }
        double average = sum / n;
        StdOut.println("Average is " + average);
    }
}
