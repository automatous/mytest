package com.example.demo.syntax;

public class StringFormatTest {
    public static void main(String[] args) {
        double d = 0.1234567891011121314;
        String s0 = String.format("%14.0f", d);
        System.out.println(s0.length());
        System.out.println(s0);
        String s1 = String.format("%10.4f", d);
        System.out.println(s1.length());
        System.out.println(s1);
        String s2 = String.format("%10.10f", d);
        System.out.println(s2.length());
        System.out.println(s2);
//        String s3 = String.format("%10.10f\n", d);
//        System.out.println(s3.length());
//        System.out.println(s3);

    }
}
