package com.example.demo.syntax;

public class MethodReferenceTest {

    interface Initializer{
        void onStartup(String s);
    }

    public void foo(String s) {
        System.out.println("foo: " + s);
    }

    public Initializer bar() {
        return this::foo;
    }

    public static void main(String[] args) {
        MethodReferenceTest test = new MethodReferenceTest();
        Initializer bar = test.bar();
        bar.onStartup("bar");
    }
}
