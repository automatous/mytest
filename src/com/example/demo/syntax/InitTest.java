package com.example.demo.syntax;

public class InitTest {
    {
        System.out.println("instance....");
    }

    public InitTest() {
        System.out.println("constructor....");
    }

    public static void main(String[] args) {
        InitTest initTest = new InitTest();
        System.out.println(initTest);
    }
}
