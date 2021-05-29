package com.example.demo.alg;

import org.junit.Test;

public class StringAlgTest {


    public static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void swapSubString(char[] arr, int a, int b) {
        while (a < b) {
            swap(arr, a, b);
            a++;
            b--;
        }
    }

    // ============================== 单词顺序反转 =================================

    public static String revert(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        swapSubString(arr, i, j);
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == ' ') {
                swapSubString(arr, i, k - 1);
                i = k + 1;
            }
        }
        return new String(arr);
    }

    @Test
    public void testStr() {
        String s = " hello world ";
        char[] arr = s.toCharArray();
//        swapSubString(arr, 0, arr.length - 1);
//        System.out.println(new String(arr));
//        swapSubString(arr, 0, arr.length - 1);
//        System.out.println(new String(arr));
        String revert = revert(s);
        System.out.println(revert);
    }
    // ============================== 单词顺序反转 =================================
}
