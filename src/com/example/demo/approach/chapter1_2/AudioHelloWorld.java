package com.example.demo.approach.chapter1_2;

import com.example.demo.stdio.StdAudio;

public class AudioHelloWorld {
    public static void main(String[] args) {
        int SAMPLING_RATE = 44100;
        int hz = 440;
        double duration = 1.0;
        int n = (int) (SAMPLING_RATE * duration);
        double[] a = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
        }

        long start = System.currentTimeMillis();
        StdAudio.play(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
