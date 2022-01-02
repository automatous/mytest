package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdDraw;
import com.example.demo.stdio.StdRandom;

public class Brownian {
    public static void main(String[] args) {
//        double hurst = 1;
//        double hurst = 0.5;
//        double hurst = 0.05;
        double hurst = 0.005;
        double s = Math.pow(2, 2 * hurst);
        curve(0, 0.5, 1.0, 0.5, 0.01, s);
    }

    public static void curve(double x0, double y0,
                             double x1, double y1,
                             double var, double s) {
        if (x1 - x0 < .01) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double delta = StdRandom.gaussian(0, Math.sqrt(var));
        curve(x0, y0, xm, ym + delta, var / s, s);
        curve(xm, ym + delta, x1, y1, var / s, s);
    }
}
