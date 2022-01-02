package com.example.demo.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FortyTest {


    @Test
    public void test41() {

    }



    @Test
    public void test41_2() {
        String s = "google";
        System.out.println(firstAppearingOnce(s));
    }

    public static char firstAppearingOnce(String s) {
        if (s == null || s.length() == 0) {
            return '#';
        }

        int[] cnts = new int[256];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnts[c]++;
            queue.add(c);
            while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
                queue.poll();
            }
        }

        return queue.isEmpty() ? '#' : queue.poll();
    }

    @Test
    public void test42() {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(greatestSumOfSubarray(arr));
    }

    public static int greatestSumOfSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = nums[0];
        int gs = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = sum <= 0 ? nums[i] : sum + nums[i];
            gs = Math.max(gs, sum);
        }

        return gs;
    }


    @Test
    public void test45() {
        int[] arr = {3, 32, 321};
        System.out.println(printMinNumber(arr));
    }

    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));    // 这种构造排序的思想, 可以作为经典的例子记起来
        String ret = "";
        for (String str : nums)
            ret += str;
        return ret;
    }


    @Test
    public void test48() {
        String s = "arabcacfr";
        System.out.println(longestSubstringWithoutDuplication(s));
    }

    public static int longestSubstringWithoutDuplication(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int curLen = 0;
        int maxLen = 0;
        int[] preIds = new int[26];
        Arrays.fill(preIds, -1);
        for (int i = 0, len = s.length(); i < len; i++) {
            int c = s.charAt(i) - 'a';
            int preI = preIds[c];
            if (preIds[c] == -1 || i - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - preI;
            }

            preIds[c] = i;
        }

        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

}
