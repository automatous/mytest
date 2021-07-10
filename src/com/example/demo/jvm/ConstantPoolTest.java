package com.example.demo.jvm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConstantPoolTest {

    @Test
    public void testMerge() {
//        String s0 = "3,7";
        String s1 = "1,3";
        String s2 = "0,1";
        String s3 = "7,10";
        List<String> ss = new ArrayList<>();
//        ss.add(s0);
        ss.add(s1);
        ss.add(s2);
        ss.add(s3);
        ss.sort(Comparator.naturalOrder());
        List<String> mergeSs = new ArrayList<>();
        String start = "";
        String p1;
        String p2;
        for (int i = 0; i < ss.size() - 1; i++) {
            p1 = ss.get(i);
            p2 = ss.get(i + 1);
            String[] pa1 = p1.split(",");
            String[] pa2 = p2.split(",");
            if ("".equals(start)) {
                start = pa1[0];
            }
            if (!pa1[1].equals(pa2[0])) {
                mergeSs.add(start + "~" + pa1[1]);
                start = pa2[0];
            }
            if ((i + 1) == (ss.size() - 1)) {
                mergeSs.add(start + "~" + pa2[1]);
            }
        }
        System.out.println(mergeSs);
    }

    public static void main(String[] args) {
        String s1 = "yu";
        String s2 = "ki";
        String s3 = s1 + s2;
        String s4 = "yuki";
        String s5 = "yu" + "ki";
        System.out.println(s3 == s4);   // false
        System.out.println(s5 == s4);   // true
    }
}
