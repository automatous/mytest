package com.example.demo.offer;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FiftyTest {


    @Test
    public void test50() {

    }

    public int firstNotRepeatedChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] cnts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnts[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }


    @Test
    public void test52() {

    }

    public static ListNode findFirstCommonNode(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        ListNode p1 = node1, p2 = node2;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : node2;
            p2 = p2 != null ? p2.next : node1;
        }

        return p1;
    }


    @Test
    public void test53() {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 6};
        System.out.println(getCntOfK(nums, 6));
    }


    public static int getCntOfK(int[] nums, int k) {
        int first = binarySearch(nums, k);
        int last = binarySearch(nums, k + 1);
        return (first == nums.length || nums[first] != k) ? 0 : (last - first);
    }

    public static int binarySearch(int[] nums, int k) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }


    @Test
    public void test54() {

    }

    public static TreeNode kthNode(TreeNode root, int k) {
        TreeNode[] ret = new TreeNode[1];
        int[] cnt = {0};
        inOrder(root, ret, cnt, k);
        return ret[0];
    }

    public static void inOrder(TreeNode root, TreeNode[] ret, int[] cnt, int k) {
        if (root == null || ret[0] != null) {
            return;
        }

        inOrder(root.left, ret, cnt, k);
        if (cnt[0]++ == k) {
            ret[0] = root;
        }
        inOrder(root.right, ret, cnt, k);
    }


    @Test
    public void test55_1() {

    }

    public static int height(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }


    @Test
    public void test55_2() {

    }

    public static boolean isBalance(TreeNode root) {
        boolean[] ret = {true};
        height(root, ret);
        return ret[0];
    }

    public static int height(TreeNode node, boolean[] isBalance) {
        // 一旦判定不为平衡时, 即可直接返回
        if (node == null || !isBalance[0]) {
            return 0;
        }
        int left = height(node.left, isBalance);
        int right = height(node.left, isBalance);
        if (Math.abs(left - right) > 1) {
            isBalance[0] = false;
        }

        return 1 + Math.max(left, right);
    }


    @Test
    public void test56() {

    }


    public int[] findNumsAppearOnce(int[] nums) {
        int[] ret = new int[2];
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;

        for (int num : nums) {
            if ((num & diff) == 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }

        return ret;
    }


    @Test
    public void test57_1() {

    }


    public static List<Integer> findNumbersWithSum(int[] arr, int sum) {
        List<Integer> ret = new ArrayList<>();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int s = arr[i] + arr[j];
            if (s == sum) {
                ret.add(i);
                ret.add(j);
                break;
            } else if (s < sum) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }


    @Test
    public void test57_2() {
        int sum = 100;
        System.out.println(findContinuousSequence(sum));
    }


    public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }



    @Test
    public void test58_2() {
        String s = "abcXYZdef";
        int n = 3;
        System.out.println(reversePartition(s, n));
    }


    @Test
    public void test58_1() {
//        String s = "I am a student.";
//        String s = "  I am a student.";
//        String s = "I am a student.  ";
        String s = "  I am a student.  ";
        System.out.println(reverseSentence(s));
    }


    public static String reversePartition(String s, int n) {
        int length = 0;
        if (s == null || (length = s.length()) == 0 || n <= 0 || length <= n) {
            return s;
        }

        char[] arr = s.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, length - 1);
        reverse(arr, 0, length - 1);
        return new String(arr);
    }


    public static String reverseSentence(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] arr = s.toCharArray();
        int length = s.length();
        reverse(arr, 0, length - 1);

        int i = 0, j = 0;
        for (; i < length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, j, i - 1);
                j = i + 1;
            }
        }

        reverse(arr, j, length - 1);
        return new String(arr);
    }


    public static void reverse(char[] arr, int a, int b) {
        while (a < b) {
            swap(arr, a++, b--);
        }
    }

    public static void swap(char[] arr, int a, int b) {
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }


    @Test
    public void test59() {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        List<Integer> integers = maxInWindows(arr, size);   // {4, 4, 6, 6, 6, 5}
        System.out.println(integers);
    }

    public static List<Integer> maxInWindows(int[] arr, int size) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        List<Integer> ret = new ArrayList<>();

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            maxQueue.add(arr[i]);
        }
        ret.add(maxQueue.peek());

        for (int i = 0, j = i + size; j < arr.length; i++, j++) {
            maxQueue.remove(arr[i]);
            maxQueue.add(arr[j]);
            ret.add(maxQueue.peek());
        }

        return ret;
    }


    private static class ListNode {
        int value;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    '}';
        }
    }


    private static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }


}
