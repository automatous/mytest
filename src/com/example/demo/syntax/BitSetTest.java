package com.example.demo.syntax;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class BitSetTest {


    @Test
    public void test00() {
        BitSet bs = new BitSet(256);
        bs.set(16);
        bs.set(0);
        System.out.println(bs);
    }

}
