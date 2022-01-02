package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdAudio;
import com.example.demo.stdio.StdDraw;
import com.example.demo.stdio.StdIn;
import com.example.demo.stdio.StdStats;

public class PlayThatTune {
    public static void main(String[] args) {
        int SAMPLING_RATE = 44100;
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int n = (int) (SAMPLING_RATE * duration);
            double[] a = new double[n + 1];
            for (int i = 0; i <= n; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
            }

            // 音频输出
            StdAudio.play(a);

            // 图像输出 1/1000秒  1102个样本
//            double[] ca = new double[1102];
//            for (int i = 0; i < ca.length; i++) {
//                ca[i] = a[i];
//            }
//            StdDraw.setCanvasSize(1024, 480);
//            StdDraw.setXscale(-1, ca.length);
//            StdDraw.setYscale(-1, 1);
//            StdStats.plotLines(ca);
        }
    }
}
