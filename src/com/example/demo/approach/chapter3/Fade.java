package com.example.demo.approach.chapter3;

import com.example.demo.stdio.Picture;

import java.awt.*;

public class Fade {

    public static Color blend(Color c1, Color c2, double alpha) {
        double r = (1 - alpha) * c1.getRed() + alpha * c2.getRed();
        double g = (1 - alpha) * c1.getRed() + alpha * c2.getRed();
        double b = (1 - alpha) * c1.getRed() + alpha * c2.getRed();
        return new Color((int) r, (int) g, (int) b);
    }

    public static void main(String[] args) {
        String darwin = "F:\\download\\darwin.jpg";
        String mandrill = "F:\\download\\mandrill.jpg";
        Picture d = new Picture(darwin);
        Picture m = new Picture(mandrill);
        int w = 300, h = 300;
        d = Scale.scale(w, h, d);
        m = Scale.scale(w, h, m);
        int n = 7;
        for (int i = 0; i <= n; i++) {
            Picture p = new Picture(w, h);
            for (int col = 0; col < w; col++) {
                for (int row = 0; row < h; row++) {
                    Color c2 = m.get(col, row);
                    Color c1 = d.get(col, row);
                    double alpha = (double) i / n;
                    Color c = blend(c1, c2, alpha);
                    p.set(col, row, c);
                }
            }
            p.show();
        }

    }
}
