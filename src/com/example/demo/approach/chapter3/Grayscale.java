package com.example.demo.approach.chapter3;

import com.example.demo.stdio.Picture;

import java.awt.*;

public class Grayscale {
    public static void main(String[] args) {
        String filePath = "F:\\download\\";
        String darwin = filePath + "darwin.jpg";
        String mandrill = filePath + "mandrill.jpg";

        Picture picture = new Picture(darwin);
//        Picture picture = new Picture(mandrill);
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                Color color = picture.get(col, row);
                Color gray = Luminance.toGray(color);
                picture.set(col, row, gray);
            }
        }
        picture.show();
    }
}
