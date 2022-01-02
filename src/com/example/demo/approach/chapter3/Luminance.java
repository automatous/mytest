package com.example.demo.approach.chapter3;

import com.example.demo.stdio.StdOut;

import java.awt.*;

public class Luminance {
    public static double intensity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return 0.299 * r + 0.587 * g + 0.114 * b;
    }

    public static Color toGray(Color color) {
        int y = (int) Math.round(intensity(color));
        Color gray = new Color(y, y, y);
        return gray;
    }

    public static boolean areCompatible(Color a, Color b) {
        return Math.abs(intensity(a) - intensity(b)) >= 128.0;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{232, 232, 232, 0, 0, 0};
//        int[] a = new int[]{9, 90, 166, 232, 232, 232};
        int[] a = new int[]{9, 90, 166, 0, 0, 0};
        Color c1 = new Color(a[0], a[1], a[2]);
        Color c2 = new Color(a[3], a[4], a[5]);
        StdOut.println(areCompatible(c1, c2));
    }
}
