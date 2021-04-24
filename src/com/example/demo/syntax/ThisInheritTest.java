package com.example.demo.syntax;

public class ThisInheritTest {
    public static void main(String[] args) {
        B b = new B();
        /*
         * 结果如下:
         * B bar: b
         * A foo: a
         * 所以, 这个this不是固定不变的, 不同的上下文有不同的含义, 就近原则
         */
        b.bar();

        /*
         * 结果如下:
         * B bar: a
         * A foo: a
         * 所以, this只会在本层及其之上寻找, 之下的将不能感知到
         */
        C c = new C();
        c.bar();
    }
}

class A {
    String name = "a";

    void foo() {
        System.out.println("A foo: " + this.name);
    }
}


class B extends A {
//    String name = "b";
    void bar() {
        System.out.println("B bar: " + this.name);
        foo();
    }
}

class C extends B {
    String name = "c";
}
