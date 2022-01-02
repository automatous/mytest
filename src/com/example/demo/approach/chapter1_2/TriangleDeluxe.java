package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdDraw;
import com.example.demo.stdio.StdRandom;

public class TriangleDeluxe {
    public static void main(String[] args) {
        int trials = 1000;
        double[] cx = {.0, 1.0, .5};
        double[] cy = {.0, .0, .866};
        double x = .0, y = .0;
        for (int i = 0; i < trials; i++) {
            int r = StdRandom.uniform(3);
            x = (x + cx[r]) / 2.0;
            y = (y + cy[r]) / 2.0;
            StdDraw.point(x, y);
        }
        System.out.println("==========================");
    }
}
