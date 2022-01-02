package com.example.demo.offer;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ThirtyTest {


    @Test
    public void test30() {

    }

    public static void minStack(int i) {
        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        dataStack.pop();
        minStack.pop();

        dataStack.push(i);
        minStack.push(minStack.isEmpty() ? i : Math.min(i, minStack.peek()));

        int top = dataStack.peek();
    }


    @Test
    public void test31() {

    }


    public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIdx = 0, popIdx = 0; pushIdx < n; pushIdx++) {
            stack.push(pushSequence[pushIdx]);
            while (popIdx < n && stack.isEmpty() && stack.peek() == popSequence[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test39() {
        int[] nums = {1, 2, 1, 2, 2};
        System.out.println(moreThanHalfNum(nums));
    }


    public static int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority) {
                cnt++;
            }
        }

        return cnt > nums.length / 2 ? majority : 0;
    }

}
