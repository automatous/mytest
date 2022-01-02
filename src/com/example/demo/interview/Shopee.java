package com.example.demo.interview;

import org.junit.jupiter.api.Test;

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
    public ListNode findKthFromTail(ListNode head, int k) {
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
     */


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
     */


    /*









    43. 数组-搜索插入位置

    44. 复杂链表的实现

    45. 非递归实现前序遍历二叉树

    46. 括号生成

    47. 有环链表的入环口

    48. K个一组翻转链表

    49. 有a,b,c,....n种面值的硬币, 组成k的面值, 求使用的最少的硬币

    50. 二叉树中序遍历
    */
}
