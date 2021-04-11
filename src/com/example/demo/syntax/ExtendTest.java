package com.example.demo.syntax;

public class ExtendTest {
    public void foo(String aa) {
        System.out.println("parent call foo(" + aa + ")");
    }
}

class ChildExtendTest extends ExtendTest {
    @Override
    public void foo(String aa) {
        System.out.println("child call foo(" + aa + ")");
        super.foo(aa);
    }

    public static void main(String[] args) {
        ChildExtendTest child = new ChildExtendTest();
        child.foo("hi~");
    }
}
