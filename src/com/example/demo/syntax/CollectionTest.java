package com.example.demo.syntax;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionTest {

    @Test
    public void testLinkedHashMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("c", 3);
        map.put("b", 2);
        map.put("d", 4);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next);
        }
        System.out.println(map);

        System.out.println(map.get("c"));
        map.put("c", 33);
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next);
        }
        System.out.println(map);

        map.remove("c");
        map.put("c", 333);
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next);
        }
        System.out.println(map);
    }


    public static void main(String[] args) {
        int[] bar = bar();
        System.out.println(Arrays.toString(bar));
    }


    public static int[] bar() {
        int i[] = {0, 0};
        return i;
    }
}
