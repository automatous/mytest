package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdDraw;

public class Triangle {
    public static void main(String[] args) {

//        int n = 5;
//        StdDraw.setCanvasSize(1024, 1024);
//        StdDraw.setXscale(0, n);
//        StdDraw.setYscale(0, n);
//        StdDraw.setPenRadius(1);
//        StdDraw.point(n / 2, n / 2);
//        for (int i = 0; i < n; i++) {
//            StdDraw.line(0, n - i, i, 0);
//        }

        // ===============================================

        double t = Math.sqrt(3) / 2;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(0.0, 0.01, 1.0, 0.01);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);
        StdDraw.point(0.5, t / 3.0);
    }
}
