package com.example.demo.approach.chapter3;

import com.example.demo.stdio.StdDraw;

import java.awt.*;

public class AlbersSquares {
    public static void main(String[] args) {
        int r1 = 9, g1 = 90, b1 = 166;
        int r2 = 100, g2 = 100, b2 = 100;
        Color c1 = new Color(r1, g1, b1);
        Color c2 = new Color(r2, g2, b2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.25, .5, .2);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.25, .5, .1);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.75, .5, .2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.75, .5, .1);
    }
}
