package com.example.demo.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SixtyTest {


    @Test
    public void test61() {

    }


    public static boolean isContinuous(int[] arr) {
        if (arr == null || arr.length != 5) {
            return false;
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i : arr) {
            if (i == 0) {
                cnt++;
            }
        }

        for (int i = cnt; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            cnt -= arr[i + 1] - arr[i] - 1;
        }

        return cnt >= 0;
    }


    @Test
    public void test63() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int min = arr[0], mp = 0;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            mp = Math.max(mp, arr[i] - min);
        }

        return mp;
    }


    @Test
    public void test64() {
//        int n = 100;
        int n = 10;
        System.out.println(sumRecursive(n));
    }

    public static int sumRecursive(int n) {
        int sum = n;
        boolean b = (n > 0) && (sum += sumRecursive(n - 1)) > 0;
        return sum;
    }


    @Test
    public void test65() {
//        int a = 1, b = 1;
//        int a = -1, b = -1;
//        int a = -1, b = 0;
//        int a = 0, b = -1;
//        System.out.println(addRecursive(a, b));

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d + %d = %d\n", i - 1, i, addRecursive(i - 1, i));
        }

    }

    public static int addRecursive(int a, int b) {
        return b != 0 ? addRecursive((a ^ b), ((a & b) << 1)) : a;
    }


    @Test
    public void test66() {
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] multiply = multiply(arr);
        System.out.println(Arrays.toString(multiply));
    }

    public static int[] multiply(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int length = arr.length;
        int[] B = new int[length];

        for (int i = 0, t = 1; i < length; t *= arr[i], i++) {
            B[i] = t;
        }

        for (int i = length - 1, t = 1; i >= 0; t *= arr[i], i--) {
            B[i] *= t;
        }

        return B;
    }


    @Test
    public void test67() {
//        String s = "-123456";
//        String s = "+123456";
//        String s = "123456";
//        String s = "+" + Integer.MAX_VALUE;
        String s = "" + Integer.MIN_VALUE;
        System.out.println(str2Int(s));
    }


    public static int str2Int(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char c = s.charAt(0);
        boolean isNegative = c == '-';
        int ret = 0;
        if (c >= '0' && c <= '9') {
            ret = c - '0';
        }

        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (c < '0' || c > '9') {
                return 0;
            } else {
                ret = ret * 10 + (c - '0');
            }
        }

        return isNegative ? -ret : ret;
    }


    @Test
    public void test68Plus() {
        TreeNode root, p = null, q = null;
        root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(6,
                        p = new TreeNode(5, null, null),
                        new TreeNode(7, null, null)));
        TreeNode treeNode = bstLowestCommonAncestor(root, p, q);
        System.out.println(treeNode);
    }


    /**
     * binary search tree
     */
    public static TreeNode bstLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (p == null) {
            return q;
        } else if (q == null) {
            return p;
        }

        if (root.value > p.value && root.value > q.value) {
            return bstLowestCommonAncestor(root.left, p, q);
        } else if (root.value < p.value && root.value < q.value) {
            return bstLowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * binary tree
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


    @Test
    public void test68() {
        TreeNode root, p, q = null;
        root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        p = new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));

        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);
        System.out.println(lowestCommonAncestor);
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
