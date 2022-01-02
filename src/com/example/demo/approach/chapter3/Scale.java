package com.example.demo.approach.chapter3;

import com.example.demo.stdio.Picture;

public class Scale {

    public static Picture scale(int w, int h, Picture p) {
        Picture t = new Picture(w, h);
        for (int colT = 0; colT < w; colT++) {
            for (int rowT = 0; rowT < h; rowT++) {
                int colS = colT * p.width() / w;
                int rowS = rowT * p.height() / h;
                t.set(colT, rowT, p.get(colS, rowS));
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int w = 800, h = 800;
//        int w = 600, h = 300;
//        int w = 200, h = 400;
//        int w = 200, h = 200;
        String filePath = "F:\\download\\";
        String darwin = filePath + "darwin.jpg";
        String mandrill = filePath + "mandrill.jpg";
        Picture source = new Picture(mandrill);
//        Picture target = new Picture(w, h);
//        for (int colT = 0; colT < w; colT++) {
//            for (int rowT = 0; rowT < h; rowT++) {
//                int colS = colT * source.width() / w;
//                int rowS = rowT * source.height() / h;
//                target.set(colT, rowT, source.get(colS, rowS));
//            }
//        }

        Picture target = scale(w, h, source);
        source.show();
        target.show();
    }
}
