package com.example.demo.syntax;

import java.lang.reflect.UndeclaredThrowableException;

public class ThrowsTest {


    public void foo() throws TransactionException {
        try {
            int i = 1 / 20;
        }
        catch (Throwable ex) {
            // Transactional code threw unexpected exception -> rollback
//            throw new UndeclaredThrowableException(ex, "TransactionCallback threw undeclared checked exception");
            throw new RuntimeException();
        }
    }
}

class TransactionException extends RuntimeException {

}