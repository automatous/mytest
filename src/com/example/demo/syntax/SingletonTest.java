package com.example.demo.syntax;

public class SingletonTest {

    // 双重检查锁定
    public static class SafeDoubleCheckedLocking {
        private volatile static SafeDoubleCheckedLocking instance;

        public static SafeDoubleCheckedLocking getInstance() {
            if (instance == null) {
                synchronized (SafeDoubleCheckedLocking.class) {
                    if (instance == null) {
                        instance = new SafeDoubleCheckedLocking();
                    }
                }
            }
            return instance;
        }
    }

    // 基于类初始化的解决方案(延迟初始化方案)
    public static class InstanceFactory {
        private static class Instance {
            public static Instance instance = new Instance();
        }

        public static Instance getInstance() {
            return Instance.instance;
        }
    }

}
