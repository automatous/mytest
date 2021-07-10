package com.example.demo.jvm;

public class Klas {
    int i = 10;
    long l = 10L;
    float f = 1.1F;
    static double d = 1.1;
    int[] arr = new int[1];
//    static double d = 1.0;

    public static void main(String[] args) throws Exception {
        int[] ia = new int[0];
        int[] ia1 = new int[11];
        Klas[] ka = new Klas[0];
        Klas[] ka1 = new Klas[1];
        Klas klas = new Klas();
//        long l = 10L;
//        float f = 1.0F;
//        double d = 0.0D;
        System.out.println(klas);
        System.out.println(ia);
        System.out.println(ia1);
        System.out.println(ka);
        System.out.println(ka1);
        System.out.println(klas);
//        System.out.println(l);
//        System.out.println(f);
        System.out.println(d);
        long test = test(null, null, 0);
        long foo = foo(null);
        System.out.println(test);
        System.out.println(foo);
    }

    public static long test(String s, int[] arr, int i) {
        return 0;
    }

    public static long foo(Klas klas) {
        return 0;
    }
}
