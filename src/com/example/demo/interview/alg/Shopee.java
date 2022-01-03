package com.example.demo.interview.alg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Shopee {
    /**
     * 26. 一个人每次只能走1层或者2层楼梯, 问走到第80层一共有多少种走法?
     */
    public static int fi(int n) {
        if (n <= 1) {
            return 1;
        }
        return fi(n - 1) + fi(n - 2);
    }


    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        int f0 = 1;
        int f1 = 1;
        int f2 = 1;
        for (int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }



    @Test
    public void testFibonacci() {
        for (int i = 0; i < 16; i++) {
            System.out.println(fibonacci(i));
//            System.out.println(fi(i));
        }
    }

    /**
     * 27. 接雨水
     * https://caoxinyu.blog.csdn.net/article/details/107642789?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&utm_relevant_index=2
     */
    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = left, rightMax = right;
        while (left < right) {
            if (height[left] > height[right]) {
                if (height[right] < height[rightMax]) {
                    result += height[rightMax] - height[right];
                } else {
                    rightMax = right;
                }
                right--;
            } else {
                if (height[left] > height[leftMax]) {
                    leftMax = right;
                } else {
                    result += height[leftMax] - height[left];
                }
                left++;
            }
        }

        return result;
    }

    @Test
    public void testTrap() {
        int[][] as = {
                {0,1,0,2,1,0,1,3,2,1,2,1},  // 6
                {4,2,0,3,2,5},              // 9
                {4,3,2,0,1,1,5},            // 13
                {1,2,3,4,4,3,2,1}           // 0
        };

        for (int[] a : as) {
            System.out.println(trap(a));
        }
    }

    /**
     * 28. 单词最小编辑次数
     * https://www.cnblogs.com/robert-dlut/p/4077540.html
     * https://blog.csdn.net/dy0558775258712345/article/details/37960613
     */
    public static int minEdit(String o, String t) {
        int lo = o.length();
        int lt = t.length();
        char[] co = o.toCharArray();
        char[] ct = t.toCharArray();

        int[][] dp = new int[lo + 1][lt + 1];

        for (int i = 0; i <= lo; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= lt; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= lo; i++) {
            for (int j = 1; j <= lt; j++) {
                if (co[i - 1] == ct[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];            // 不需要编辑
                } else {
                    int i1 = dp[i][j - 1] + 1;                   // j中插入字符
                    int i2 = dp[i - 1][j] + 1;                   // j中删除字符
                    int i3 = dp[i - 1][j - 1] + 1;               // j中替换字符
                    dp[i][j] = Math.min(Math.min(i1, i2), i3);
                }
            }
        }

        return dp[lo][lt];
    }

    @Test
    public void testMinEdit() {
        String[][] saa = {
                {"ABCD", "ACD"},
                {"ABCD", "AC"},
                {"ABCD", "A"},
                {"A", "ACD"},
                {"", "ACD"},
        };

        for (String[] sa : saa) {
            System.out.println(minEdit(sa[0], sa[1]));
        }
    }


    /**
     * 29. 将2个有序递增链表合并成1个有序的递增链表
     */

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    public ListNode MergeIterative(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return head.next;
    }

    /**
     * 30. 动态规划求2个串中最大公共子串
     */
    public static int[][] getdp(char[] ca1, char[] ca2) {
        int[][] dp = new int[ca1.length][ca2.length];

        for (int i = 0; i < ca1.length; i++) {
            if (ca1[i] == ca2[0]) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < ca2.length; j++) {
            if (ca1[0] == ca2[j]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < ca1.length; i++) {
            for (int j = 1; j < ca2.length; j++) {
                if (ca1[i] == ca2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        return dp;
    }

    public static String lcs(String s1, String s2) {
        if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2)) {
            return "";
        }

        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        int[][] dp = getdp(ca1, ca2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < ca1.length; i++) {
            for (int j = 0; j < ca2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }

        return s1.substring(end - max + 1, end + 1);
    }


    @Test
    public void testLcs() {
        String[][] saa = {
                {"abcde", "bebcd"},
                {"1AB2345CD", "12345EF"},
                {"ABCD", "A"},
                {"A", "ACD"},
                {"", "ACD"},
        };

        for (String[] sa : saa) {
            System.out.println(lcs(sa[0], sa[1]));
        }
    }


    /**
     * 31. 字符串相加
     */

    public static String plusString(String s1, String s2) {
        try {
            StringBuilder num1sb = new StringBuilder(s1).reverse();
            StringBuilder num2sb = new StringBuilder(s2).reverse();
            StringBuilder result = new StringBuilder();
            int num1Length = num1sb.length();
            int num2Length = num2sb.length();
            int maxLength = Math.max(num1Length, num2Length);
            int next = 0;
            if (num1Length > num2Length) {
                for (int i = 0; i < num1Length - num2Length; i++) {
                    num2sb.append("0");
                }
            } else {
                for (int i = 0; i < num2Length - num1Length; i++) {
                    num1sb.append("0");
                }
            }
            char[] num1chars = num1sb.toString().toCharArray();
            char[] num2chars = num2sb.toString().toCharArray();

            for (int i = 0; i < maxLength; i++) {
                int num = Integer.parseInt(num1chars[i] + "") + Integer.parseInt(num2chars[i] + "") + next;
                next = 0;
                if (i != maxLength - 1){
                    if (num >= 10){
                        next = 1;
                        result.append(num - 10);
                    }else {
                        result.append(num);
                    }
                    // 最后一位要特殊处理，如果相加大于10要多加1位
                }else{
                    if (num >= 10){
                        result.append(num - 10);
                        result.append(1);
                    }else {
                        result.append(num);
                    }
                }
            }
            return  result.reverse().toString();
        } catch (Exception e) {
            return "ERROR";
        }
    }


    @Test
    public void testPlusString() {
        System.out.println(plusString("1", "1")); //2
        System.out.println(plusString("1232131248979879", "1")); //1232131248979880
        System.out.println(plusString("1232131248979879", "9231234545323423")); //10463365794303302
        System.out.println(plusString("A", "9231234545323423")); //ERROR
    }

    /**
     * 32. 实现一个LRU数据结构
     */
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> previous;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class Deque<K, V> {
        Node<K, V> head;
        Node<K, V> tail;
        int size;

        public Deque() {
        }

        public void addNode2Tail(Node<K, V> node) {
            if (node == null) {
                return;
            }

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.previous = tail;
            }
            tail = node;
            size++;
        }

        public void moveNode2Tail(Node<K, V> node) {
            if (tail == node) {
                return;
            }

            if (head == node) {
                head = node.next;
                head.previous = null;
            } else {
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }

            node.previous = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

        public Node<K, V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<K, V> ret = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = null;
                ret.next = null;
            }
            size--;
            return ret;
        }

    }

    static class MyCache<K, V> {
        private final Deque<K, V> deque;
        private final int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            this.deque = new Deque<>();
            this.capacity = capacity;
        }

        public V get(K k) {
            Node<K, V> node = deque.tail;
            while (node != null) {
                if (node.key.equals(k)) {
                    deque.moveNode2Tail(node);
                    return node.value;
                }
                node = node.previous;
            }
            return null;
        }

        public void set(K key, V value) {
            if (key == null) {
                throw new RuntimeException("key cannot be null.");
            }

            boolean addFlag = true;
            Node<K, V> node = deque.tail;
            while (node != null && addFlag) {
                if (node.key.equals(key)) {
                    node.value = value;
                    deque.moveNode2Tail(node);
                    addFlag = false;
                }
                node = node.previous;
            }

            if (addFlag) {
                Node<K, V> newNode = new Node<>(key, value);
                if (capacity == deque.size) {
                    deque.removeHead();
                    deque.addNode2Tail(newNode);
                } else {
                    deque.addNode2Tail(newNode);
                }
            }
        }
    }

    @Test
    public void testMyCache() {
        int size = 3;
        MyCache<String, Integer> cache = new MyCache<>(size);
        cache.set("A", 1);
        cache.set("B", 2);
        cache.set("C", 3);
        System.out.println(cache.get("A"));
        cache.set("D", 4);
        System.out.println();
    }


    /**
     * 33. 删除一个单向链表的倒数第N个子节点
     * 双指针
     * https://blog.csdn.net/nobody_1/article/details/111245887
     */
    public static ListNode removeNthFromTail(ListNode head, int n) {
        if (n > 0) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode p1 = dummy, p2 = dummy;
            while (p1 != null && n-- > 0) {
                p1 = p1.next;
            }

            if (p1 != null) {
                while (p1.next != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                p2.next = p2.next.next;
            }

            return dummy.next;
        }
        return head;
    }

    @Test
    public void testRemoveNthFromTail() {
        int start = 8;
        int end = 10;
        for (int i = start; i <= end; i++) {
            ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                    new ListNode(5, new ListNode(6, new ListNode(7, null))))))));
            ListNode listNode = removeNthFromTail(head, i);
            System.out.println(listNode);
        }
    }

    /**
     * https://www.nowcoder.com/discuss/198840?type=1
     * 剑指offer 22
     */
    public static ListNode findKthFromTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode P1 = head;
        while (P1 != null && k-- > 0)
            P1 = P1.next;
        if (k > 0)
            return null;
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }


    /**
     * 34. 翻转单链表
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }

    // 头插法 迭代
    public static ListNode reverseListIterative(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    /**
     *     35. 两个表
     *     404....
     */

    /**
     * 36. 二维数组中的查找(在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。)
     */
    public static boolean findFromTwoDimensionArray(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            int cmp = k - matrix[r][c];
            if (cmp > 0) {
                r++;
            } else if (cmp < 0) {
                c--;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 37. 小驼峰格式转换
     * TestVariable
     * test_variable
     * TEST_VARIABLE，
     * 最终输出为: testVariable
     */
    public static String toCamelCase(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        String[] sa = s.split("_");
        StringBuilder sb = new StringBuilder();
        if (sa.length == 1) {
            // 没有下划线, 首字母改小写即可
            sb.append(Character.toLowerCase(s.charAt(0)));
            sb.append(s.substring(1));
        } else {
            char c = sa[0].charAt(0);
            if ('a' <= c && 'z' >= c) {
                // 有下划线, 且全为小写字母的情况
                sb.append(sa[0]);
                for (int i = 1; i < sa.length; i++) {
                    sb.append(Character.toUpperCase(sa[i].charAt(0)));
                    sb.append(sa[i].substring(1));
                }
            } else if ('A' <= c && 'Z' >= c) {
                // 有下划线, 且全为大写字母的情况
                sb.append(sa[0].toLowerCase());
                for (int i = 1; i < sa.length; i++) {
                    String ts = sa[i].toLowerCase();
                    sb.append(Character.toUpperCase(ts.charAt(0)));
                    sb.append(ts.substring(1));
                }
            }
        }

        return sb.toString();
    }

    @Test
    public void testToCamelCase() {
        String[] sa = {
                "TestVariable",
                "test_variable",
                "TEST_VARIABLE"
        };
        for (String s : sa) {
            String ts = toCamelCase(s);
            System.out.print(ts);
            System.out.println("\t" + "testVariable".equals(ts));
        }
    }

    /**
     * 38. 反转单链表(同34)
     */


    /**
     * 39. 三数之和
     */
    public static int countTriples(int[] a, int v) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == v) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 40. 二分查找算法
     */
    public static int binarySearch(int[] a, int k) {
        return bs(a, k, 0, a.length);
    }

    public static int bs(int[] a, int k, int l, int r) {
        if (l >= r) {
            return -1;
        }

        int m = l + (r - l) / 2;
        if (a[m] > k) {
            return bs(a, k, l, m);
        } else if (a[m] < k) {
            return bs(a, k, m + 1, r);
        } else {
            return m;
        }
    }


    /**
     * 插入排序
     */
    public static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int p = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > p) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = p;
        }
    }

    /**
     * 41. 下面的代码在控制台打印顺序如何?
     * 404....
     */


    /**
     * 42. 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * https://blog.csdn.net/zzzfffei/article/details/88054956
     * https://www.cnblogs.com/lippon/p/14155714.html
     */
    public static boolean canJump(int[] a) {
        if (a == null) {
            return false;
        } else if (a.length <= 1) {
            return true;
        }

        int len = a.length;
        int finPos = len - 1;
        int maxPosCanJump = a[0];   // 记录当前能跳到哪里
        for (int i = 0; i < finPos; i++) {
            // 先看一下, 能不能到达位置i
            if (i <= maxPosCanJump) {
                // 能够到达, 就看一下从i位置能够跳到哪
                int iPosCanJumpTo = i + a[i];
                if (iPosCanJumpTo >= finPos) {
                    return true;
                } else if (iPosCanJumpTo > maxPosCanJump) {
                    maxPosCanJump = iPosCanJumpTo;
                }
            } else {
                // 如果跳不到i位置, 会出现类似 1 0 2 这种情况, 跳到某个位置就不动了
                return false;
            }
        }
        return false;
    }

    public static int jump(int[] a) {
        if (!canJump(a)) {
            throw new RuntimeException("cannot jump....");
        }
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= a[i] + i && j < n; j++) {
                // 状态转移，比较从前一个位置跳过来的次数
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }

        return dp[n - 1];
    }

    public static int jumpGreedy(int[] a) {
        if (!canJump(a)) {
            throw new RuntimeException("cannot jump....");
        }
        int res = 0;
        int max = 0, end = 0;
        for (int i = 0; i < a.length - 1; i++) {
            max = Math.max(max, a[i] + i);
            // 到达一个范围的终点，说明之前一跳不可能超过这个位置，所以跳跃次数必须增加
            if (end == i) {
                res += 1;
                end = max;
            }
        }

        return res;
    }

    @Test
    public void testJump() {
        int[][] aar = {
                {2, 3, 1, 1, 4},    // 2
                {2, 1, 2, 1, 4},    // 2
                {1, 2, 1, 1, 3},    // 3
                {10, 2, 1, 1, 3},    // 1
                {3, 2, 1, 0, 4},    // cannot jump....
        };

        for (int i = 0; i < aar.length; i++) {
            System.out.println(jump(aar[i]));
//            System.out.println(jumpGreedy(aar[i]));
        }
    }

    /**
     * 43. 数组-搜索插入位置
     */
    public static int searchInsertPosition(int[] a, int k) {
        return partition(a, k, 0, a.length);
    }

    public static int partition(int[] a, int k, int l, int r) {
        if (l >= r) {
            return r;
        }
        int m = l + (r - l) / 2;
        if (a[m] > k) {
            return partition(a, k, l, m);
        } else if (a[m] < k) {
            return partition(a, k, m + 1, r);
        } else {
            return m;
        }
    }

    @Test
    public void testSearchInsertPosition() {
        Node<int[], int[][]> node = new Node<>(
                new int[]{
                        5,
                        4,
                        7,
                        0,
                        2
                },
                new int[][]{
                        {1, 3, 5, 6},  // 5 -> 2
                        {1, 3, 5, 6},  // 2 -> 1; 4 -> 2
                        {1, 3, 5, 6},  // 7 -> 4
                        {1, 3, 5, 6},  // 0 -> 0
                        {1}         // 0 -> 0; 2 -> 1
                }
        );

        for (int i = 0; i < node.key.length; i++) {
            System.out.println(searchInsertPosition(node.value[i], node.key[i]));
        }
    }

    /**
     * 44. 复杂链表的实现
     */
    static class RandomListNode {
        int val;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int val) {
            this.val = val;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }


    /**
     * 45. 非递归实现前序遍历二叉树
     */
    static class BinaryTree {
        int val;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree() {
        }

        public BinaryTree(int val) {
            this.val = val;
        }

        public BinaryTree(int val, BinaryTree left, BinaryTree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void preOrderIterative(BinaryTree root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTree> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void inOrderIterative(BinaryTree root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTree> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void posOrderIterative(BinaryTree root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val);
        }
    }

    public static void posOrderIterativePro(BinaryTree root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        BinaryTree bt = null;
        while (!stack.isEmpty()) {
            bt = stack.peek();
            if (bt.left != null && root != bt.left && root != bt.right) {
                stack.push(bt.left);
            } else if (bt.right != null && root != bt.right) {
                stack.push(bt.right);
            } else {
                System.out.println(stack.pop().val);
                root = bt;
            }
        }
    }


    /**
     * 46. 括号生成
     * https://cloud.tencent.com/developer/article/1532911 <==> https://blog.csdn.net/kexuanxiu1163/article/details/102908323
     * https://www.jianshu.com/p/c6e332f07f4d
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
//        dfsPlus("", 0, 0, n, res);
//        dfsMinus("", n, n, res);
        recursionMinus(n, n, "", res);
        return res;
    }

    public static void recursionMinus(int left, int right, String s, List<String> res) {
        if(left == 0 && right == 0){
            res.add(s);
        }else{
            if(left > 0){
                recursionMinus(left - 1, right, s + "(", res);
            }

            if(right > left){
                recursionMinus(left, right - 1, s + ")", res);
            }
        }
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个没有用掉
     * @param right  右边的括号还有几个没有用掉
     * @param res    结果集
     */
    public static void dfsMinus(String curStr, int left, int right, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 因为每一次尝试，都使用新的字符串变量，所以没有显式的回溯过程
        // 在递归终止的时候，直接把它添加到结果集即可

        // 如果左边还有剩余，继续递归下去
        if (left > 0) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfsMinus(curStr + "(", left - 1, right, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left < right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right > 0 && left < right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfsMinus(curStr + ")", left, right - 1, res);
        }
    }

    /**
     * @param curStr    当前递归得到的结果
     * @param left      左括号用了几个
     * @param right     右括号用了几个
     * @param n         左括号、右括号一共用几个
     * @param res       结果集
     */
    public static void dfsPlus(String curStr, int left, int right, int n, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }
        // 如果左括号还没凑够，继续凑
        if (left < n) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfsPlus(curStr + "(", left + 1, right, n, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left > right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right < n && left > right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfsPlus(curStr + ")", left, right + 1, n, res);
        }
    }

    @Test
    public void testGenerateParenthesis() {
        int n = 3;
        for (int i = 0; i <= n; i++) {
            List<String> ss = generateParenthesis(i);
            System.out.println(ss);
        }
    }


    /**
     * 47. 有环链表的入环口
     *
     */
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast.next.next != null && slow != fast);

        if (fast.next.next == null) {
            throw new RuntimeException("no loop....");
        }

        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    @Test
    public void testEntryNodeOfLoop() {
        ListNode n1, n2;
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3,
                n1 = new ListNode(4, new ListNode(5, new ListNode(6, n2 = new ListNode(7))))))));
//        n2.next = n1;
        System.out.println(entryNodeOfLoop(head));
    }

    /**
     * 48. K个一组翻转链表
     * https://cloud.tencent.com/developer/article/1488136
     * https://zhuanlan.zhihu.com/p/90170262
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;

        while (pointer != null) {
            // 记录上一个子链表的尾
            ListNode lastGroup = pointer;

            int i = 0;
            for (; i < k; ++i) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }

            // 如果当前子链表的节点数满足 k, 就进行反转
            // 反之，说明程序到尾了，节点数不够，不用反转
            if (i == k) {
                // 记录下一个子链表的头
                ListNode nextGroup = pointer.next;

                // 反转当前子链表，reverse 函数返回反转后子链表的头
                ListNode reversedList = reverseGroup(lastGroup.next, nextGroup);

                // lastGroup 是上一个子链表的尾，其 next 指向当前反转子链表的头
                // 但是因为当前链表已经被反转，所以它指向的是反转后的链表的尾
                pointer = lastGroup.next;

                // 将上一个链表的尾连向反转后链表的头
                lastGroup.next = reversedList;

                // 当前反转后的链表的尾连向下一个子链表的头
                pointer.next = nextGroup;
            }
        }

        return dummy.next;
    }

    public static ListNode reverseGroup(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, temp = null;
        while ((head != null) && (head != tail)) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    ListNode reverseKGroupRecursion(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    @Test
    public void testReverseKGroup() {
        /*
         * 给定这个链表：1->2->3->4->5
         * 当 k = 2 时，应当返回: 2->1->4->3->5
         * 当 k = 3 时，应当返回: 3->2->1->4->5
         * 当 k = 4 时，应当返回: 4->3->2->1->5
         * 当 k = 5 时，应当返回: 5->4->3->2->1
         * 当 k = 6 时，应当返回: 1->2->3->4->5
         */
        for (int i = 0; i <= 6; i++) {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//            ListNode newHead = reverseKGroup(head, i);
            ListNode newHead = reverseKGroupRecursion(head, i);
            System.out.println(newHead);
        }

    }

    /**
     * 49. 1)有a,b,c,....n种面值的硬币, 组成k的面值, 求使用的最少的硬币(硬币个数没有限制)
     * 2)有a,b,c,....n种面值的硬币, 各个面值的硬币数量arr[]中对应, 组成k的面值, 求使用的最少的硬币(硬币个数有限制)
     */
    public static List<Integer> leastCoins(int[] values, int k) {
        return null;
    }

    public static int leastCoins(int[] values, int[] counts, int k) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j - 1] + (values[i] == counts[j] ? 0 : 1),
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                );
            }
        }

        return dp[n - 1][n - 1];
    }

    /**
     * 50. 二叉树中序遍历
     */
    public static void inOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void posOrder(BinaryTree root) {
        if (root == null) {
            return;
        }

        posOrder(root.left);
        posOrder(root.right);
        System.out.println(root.val);
    }

    @Test
    public void testInOrder() {
        BinaryTree root = new BinaryTree(4,
                new BinaryTree(2, new BinaryTree(1), new BinaryTree(3)),
                new BinaryTree(6, new BinaryTree(5), new BinaryTree(7)));
//        inOrder(root);
//        posOrder(root);
        posOrderIterative(root);
    }

}
