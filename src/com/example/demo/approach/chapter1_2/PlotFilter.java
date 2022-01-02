package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdDraw;
import com.example.demo.stdio.StdIn;

public class PlotFilter {
    public static void main(String[] args) {

//        double minX = Double.MAX_VALUE;
//        double maxX = Double.MIN_VALUE;
//        double minY = Double.MAX_VALUE;
//        double maxY = Double.MIN_VALUE;
//        while (!StdIn.isEmpty()) {
//            double x = StdIn.readDouble();
//            double y = StdIn.readDouble();
//            minX = Math.min(x, minX);
//            maxX = Math.max(x, maxX);
//            minY = Math.min(y, minY);
//            maxY = Math.max(y, maxY);
//        }
//
//        System.out.println(minX);
//        System.out.println(maxX);
//        System.out.println(minY);
//        System.out.println(maxY);

        // ======================================

        double x0 = StdIn.readDouble();
        double x1 = StdIn.readDouble();
        double y0 = StdIn.readDouble();
        double y1 = StdIn.readDouble();

        StdDraw.setXscale(y0, y1);
        StdDraw.setYscale(x0, x1);
//        StdDraw.enableDoubleBuffering();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = y0 + (y1 - StdIn.readDouble());
            StdDraw.point(y, x);
        }
//        StdDraw.show();


    }
}
