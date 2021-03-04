package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // =============================================================================
//        Object ret;
//        if (method.getName().equals("add")) {
//            System.out.println("--------------------------before------------------------------");
//            ret = method.invoke(target, args);
//            System.out.println("--------------------------end------------------------------");
//        } else {
//            ret = method.invoke(target, args);
//        }
//        return ret;
        // =============================================================================
        // =============================================================================
        Object ret;
        if (method.getName().equals("add")) {
//            ((UserService)proxy).add();     // stackOverflowError
//            ret = method.invoke(target, args);

            Object aa = new Object();
            System.out.println(aa);
            ret = method.invoke(proxy, args); // Unknown Source
        } else {
            ret = method.invoke(target, args);
        }
        return ret;
        // =============================================================================
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
