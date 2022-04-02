package com.example.demo.interview.alg;

import org.junit.jupiter.api.Test;

import java.nio.charset.CoderMalfunctionError;
import java.util.*;
import java.util.function.*;

public class TempTest {





    public static String binarySum(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        String ls = len1 > len2 ? s1 : s2;
        String ss = ls == s1 ? s2 : s1;
        char[] ca1 = ls.toCharArray();
        char[] ca2 = ss.toCharArray();
        len1 = ca1.length - 1;
        len2 = ca2.length - 1;
        int carry = 0;
        char[] ca = new char[ca1.length];
        for (int i = 0; i < ca1.length; i++) {
            char c1 = ca1[len1 - i];
            int t;
            if (len2 - i >= 0) {
                char c2 = ca2[len2 - i];
                t = (c1 - '0') + (c2 - '0') + carry;
            } else {
                t = (c1 - '0') + carry;
            }

            if (t == 3) {
                ca[len1 - i] = '1';
                carry = 1;
            } else if (t == 2) {
                ca[len1 - i] = '0';
                carry = 1;
            } else if (t == 1) {
                ca[len1 - i] = '1';
                carry = 0;
            } else {
                ca[len1 - i] = '0';
                carry = 0;
            }
        }

        String res = new String(ca);
        if (carry == 1) {
            res = 1 + res;
        }
        return res;
    }


    @Test
    public void testBinary() {
//        String s1 = "aa";
//        String s2 = s1;
//        System.out.println(s1 == s2);

        String s1 = "1001";
        String s2 = "1";
        String s = binarySum(s1, s2);
        System.out.println(s);
    }


    public static void insertSort(int[] a) {
        int length;
        if (a == null || (length = a.length) == 0) {
            return;
        }

        for (int i = 1; i < length; i++) {
            int p = a[i];
            int j = i - 1;
            while (j >= 0 && p < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = p;
        }
    }

    @Test
    public void testInsertSort() {
//        int[] arr = {3, 9, 8, 2, 1, 0};
        int[] arr = {1, 0, 3, 9, 8, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // ==============================================================

    public static LinkedNode reverseKNode(LinkedNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        LinkedNode newHead = null;
        LinkedNode left = null;
        LinkedNode start = head;
        LinkedNode right = null;
        LinkedNode cur = head;
        int i = 0;
        while (cur != null) {
            LinkedNode next = cur.next;
            i++;
            if (i == k) {
                right = cur.next;
                newHead = newHead == null ? cur : newHead;
                reverse(left, start, cur, right);
                left = start;
                start = right;
                i = 0;
            }
            cur = next;
        }

        return newHead;
    }

    public static void reverse(LinkedNode left, LinkedNode start, LinkedNode end, LinkedNode right) {
        LinkedNode pre = start;
        LinkedNode cur = start.next;
        while (cur != right) {
            LinkedNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }


    @Test
    public void testReversKNode() {
        /*
         * 给定这个链表：1->2->3->4->5
         * 当 k = 2 时，应当返回: 2->1->4->3->5
         * 当 k = 3 时，应当返回: 3->2->1->4->5
         * 当 k = 4 时，应当返回: 4->3->2->1->5
         * 当 k = 5 时，应当返回: 5->4->3->2->1
         * 当 k = 6 时，应当返回: 1->2->3->4->5
         */

        for (int i = 0; i <= 6; i++) {
            LinkedNode head = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5)))));
            LinkedNode newHead = reverseKNode(head, i);
//            LinkedNode newHead = reverseKNodeAgain(head, i);
            System.out.println(newHead);
        }
    }


    // =====================================================================

    static class A {
        B b;

        public A() {
            b = new B();
        }
    }

    static class B {
        A a;
        public B() {
            a = new A();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
    }


    @Test
    public void test() {
        // 语法糖
        Foo foo = new Foo();
        BiFunction<String, String, Foo> stringStringFooBiFunction = foo::foo;
        Function<String, Foo> foo1 = foo::foo;
        Supplier<Integer> getCode = foo::getCode;
        Consumer<String> setName = foo::setName;
        List<Foo> ll = new LinkedList<>();
        // stub
        // 
    }

    public static class Foo {
        private String name;
        private Integer code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Foo foo(String name) {
            return new Foo();
        }

        public Foo foo(String name, String code) {
            return new Foo();
        }
    }

    @Test
    void name() {
    }
// ======================= sort =========================

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int partition(int[] a, int s, int e) {
        return 1;
    }



    // ================================== 最少跳跃步数 =======================================

    public static boolean canJump(int[] a) {
        int length;
        if (a == null || (length = a.length) == 0) {
            return false;
        }

        int nextMax = a[0];
        for (int i = 0; i < length; i++) {
            if (nextMax < i) {
                return false;
            }
            int t = a[i] + i;
            nextMax = Math.max(nextMax, t);
        }
        return true;
    }

    public static int jump(int[] a) {
        if (!canJump(a)) {
            return -1;
        }
        int nextMax = a[0];
        int curMax = 0;
        int sum = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (curMax < i) {
                curMax = nextMax;
                sum++;
            }
            int t = a[i] + i;
            nextMax = Math.max(nextMax, t);
        }
        return sum;
    }

    @Test
    public void testJump() {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {2, 1, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        int jump = jump(nums);
        System.out.println(jump);
    }


    // =================================== 链表选择排序 ========================================
    private static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int val) {
            this.val = val;
        }

        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "LinkedNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static LinkedNode ss(LinkedNode head) {
        if (head == null) {
            return null;
        }

        LinkedNode cur = head;
        LinkedNode newHead = null;
        LinkedNode tail = null;
        while (cur != null) {
            LinkedNode preMin = preMin(cur);
            LinkedNode min;
            if (preMin == null) {
                min = cur;
            } else {
                min = preMin.next;
                preMin.next = preMin.next.next;
            }
            cur = min == cur ? cur.next : cur;

            if (tail == null) {
                newHead = min;
            } else {
                tail.next = min;
            }
            tail = min;
        }

        return newHead;
    }

    public static LinkedNode preMin(LinkedNode node) {
        if (node == null) {
            return null;
        }
        LinkedNode preMin = null;
        int min = node.val;
        LinkedNode pre = node;
        LinkedNode cur = node.next;
        while (cur != null) {
            if (min > cur.val) {
                min = cur.val;
                preMin = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return preMin;
    }


    @Test
    public void testSs() {
        LinkedNode head = new LinkedNode(4, new LinkedNode(7, new LinkedNode(5, new LinkedNode(6, new LinkedNode(2, new LinkedNode(3, new LinkedNode(0, new LinkedNode(1, null))))))));
        LinkedNode ss = ss(head);
        System.out.println(ss);
    }


    // ============================ 滑动窗口内的最大值 ==================================

    public static List<Integer> slideWindowsMax(int[] a, int n) {
        List<Integer> res = new ArrayList<>();
        int length;
        if (a == null || (length = a.length) == 0 || n < 1 || n >= length) {
            return res;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            while (!deque.isEmpty() && deque.peekLast() < a[i]) {
                deque.removeLast();
            }
            deque.addLast(a[i]);
        }

        for (int i = n - 1; i < length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < a[i]) {
                deque.removeLast();
            }
            deque.addLast(a[i]);
            res.add(deque.peekFirst() != a[i - n + 1] ? deque.peekFirst() : deque.removeFirst());
        }
        return res;
    }

    @Test
    public void testSlideWindowsMax() {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 1, 1, 2, 1};
        for (int i = 2; i <= 4; i++) {
            List<Integer> list = slideWindowsMax(nums, i);
            System.out.println(list);
        }
    }


    // ============================== 水位 ====================================
    public static int trap(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int i = 0, j = a.length - 1;
        int sum = 0;
        int lm = a[i], rm = a[j];
        while (i <= j) {
            lm = Math.max(lm, a[i]);
            rm = Math.max(rm, a[j]);

            if (lm < rm) {
                sum += lm - a[i];
                i++;
            } else {
                sum += rm - a[j];
                j--;
            }
        }
        return sum;
    }

    public static int water(int[] a) {
        int sum = 0;
        int i = 0, j = a.length - 1;
        int left = a[i], right = a[j];
        while (i <= j) {
            while (i <= j && a[i] >= left) {
                left = a[i];
                i++;
            }
            while (i <= j && a[j] >= right) {
                right = a[j];
                j--;
            }

            if (left < right) {
                sum += (left - a[i]);
                i++;
            } else {
                sum += (right - a[j]);
                j--;
            }
        }
        return sum;
    }


    @Test
    public void testWater() {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 1, 1, 2, 1};
//        int sum = water(nums);
        int sum = trap(nums);
        System.out.println(sum);
    }


    // =========================== 2数之和 & n数之和 ==================================

    // n数之和
    public static List<List<Integer>> nSum(int[] a, int n, int target) {
        Arrays.sort(a);
        return nSum(a, 0, n, target);
    }

    public static List<List<Integer>> nSum(int[] a, int start, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = a.length;
        if (n < 2 || start >= length) {
            return res;
        }

        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                int sum = a[lo] + a[hi];
                int left = a[lo], right = a[hi];
                if (sum < target) {
                    while (lo < hi && a[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && a[hi] == right) {
                        hi--;
                    }
                } else {
                    res.add(Arrays.asList(a[lo], a[hi]));
                    while (lo < hi && a[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && a[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> subList = nSum(a, i + 1, n - 1, target - a[i]);
                int t = a[i];
                subList.forEach(sl -> {
                    List<Integer> list = new ArrayList<>(sl);
                    list.add(t);
                    res.add(list);
                });

                while (i < length && a[i] == t) {
                    i++;
                }
            }
        }
        return res;
    }

    // 两数之和
    public static List<List<Integer>> twoSum(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int sum = a[lo] + a[hi];
            int left = a[lo], right = a[hi];
            if (sum < target) {
                while (lo < hi && a[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && a[hi] == right) {
                    hi--;
                }
            } else {
                res.add(Arrays.asList(a[lo], a[hi]));
                while (lo < hi && a[lo] == left) {
                    lo++;
                }
                while (lo < hi && a[hi] == right) {
                    hi--;
                }
            }
        }

        return res;
    }


    @Test
    public void testTwoSum() {
        int[] nums = {-1, 0, 1, 2, -1, 4};
//        int[] nums = {1, 1, 1, 2, 2, 3, 3};
//        List<List<Integer>> lists = twoSum(nums, 4);
//        System.out.println(lists);

        for (int i = 2; i <= 4; i++) {
            List<List<Integer>> lists = nSum(nums, i, 0);
//            List<List<Integer>> lists = nSum(nums, i, 4);
            System.out.println(lists);
            System.out.println();
        }
    }










    // ====================================== 合并区间 ========================================

    static class Interval {
        int start;
        int end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }


    static public List<Interval> mergeInterval(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Interval> res = new ArrayList<>();
        int size = intervals.size();
        int i = 0;
        while (i < size) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int maxEnd = end;
            while (i < size - 1 && intervals.get(i + 1).start < end) {
                maxEnd = Math.max(intervals.get(i + 1).end, end);
                i++;
            }
            res.add(new Interval(start, maxEnd));
            i++;
        }
        return res;
    }


    @Test
    public void testMergeInterval() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(10, 30));
        intervals.add(new Interval(20, 60));
        intervals.add(new Interval(80, 100));
        intervals.add(new Interval(150, 180));
        List<Interval> mi = mergeInterval(intervals);
        System.out.println(mi);
    }


    // ====================================== 字符反转 ========================================


    public static void reverse(char[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }

    public static void swap(char[] arr, int a, int b) {
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static String reverseSentence(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        char[] ca = s.toCharArray();
        int length = s.length();
        int i = 0, j = 0;
        while (i < length) {
            if (ca[i] == ' ') {
                reverse(ca, j, i - 1);
                j = i + 1;
            }
            i++;
        }
        reverse(ca, j, length - 1);
        reverse(ca, 0, length - 1);
        return new String(ca);
    }

    @Test
    public void testReverseSentence() {
//        String s = "the sky is blue";
        String s = " the sky is blue  ";
        String rs = reverseSentence(s);
        System.out.println(rs); // blue is sky the
    }
}
