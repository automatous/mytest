package com.example.demo.syntax;

public class VariableArrayTest {
    public static void foo(int i, String... args) {
        System.out.println("i: " + i + ", args.length: " + args.length);
    }

    public static void bar(int i, String[] args) {
        System.out.println("i: " + i + ", args.length: " + args.length);
    }

    public static void main(String[] args) {
        int i = 100;
        foo(i);
        bar(i, new String[0]);
    }
}
