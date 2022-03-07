package com.example.demo.syntax;

public class OverrideTest {
    static class Fruit {
        String name;

        public Fruit getNewOne(Fruit fruit) {
            return null;
        }
    }

    static class Apple extends Fruit {
        // 重写 & 重载 都是根据方法签名来区分的
        // 由此可以看出, 方法签名, 只与方法名和参数名有关(方法名 & 参数名, 必须一致), 与返回值无关
        @Override
        public Apple getNewOne(Fruit fruit) {
            return null;
        }
    }

    static class Banana extends Fruit {
        @Override
        public Banana getNewOne(Fruit fruit) {
            return null;
        }
    }



}
