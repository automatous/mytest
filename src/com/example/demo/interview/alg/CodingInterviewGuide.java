package com.example.demo.interview.alg;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CodingInterviewGuide {


    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== xx =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\
    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== xx =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/

    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== list or tree =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    public static LinkedNode getIntersectNode(LinkedNode h1, LinkedNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }

        LinkedNode e1 = getLoopLinkedNode(h1);
        LinkedNode e2 = getLoopLinkedNode(h2);
        if (e1 == null && e2 == null) {
            return noLoopFirstCommonNode(h1, h2);
        } else if (e1 != null && e2 != null) {
            return bothLoopFirstCommonNode(h1, e1, h2, e2);
        }
        return null;
    }

    @Test
    public void testGetIntersectNode() {
        LinkedNode n0, n1, n2, n3, n4, n5, n6, n7;
        LinkedNode h1 = n0 = new LinkedNode(0, n1 = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3,
                n4 = new LinkedNode(4, new LinkedNode(5, n6 = new LinkedNode(6,
                        n7 = new LinkedNode(7))))))));
        n7.next = n1;

//        n7.next = n4;
//        LinkedNode h2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, n3 = new LinkedNode(3))));
//        n3.next = n4;

//        LinkedNode h2 = n0 = new LinkedNode(0);
//        n0.next = n1;

        LinkedNode h2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, n5 = new LinkedNode(5))))));
        n5.next = n6;

        LinkedNode intersectNode = getIntersectNode(h1, h2);
        System.out.println(intersectNode);
    }

    public static LinkedNode bothLoopFirstCommonNode(LinkedNode h1, LinkedNode e1, LinkedNode h2, LinkedNode e2) {
        if (h1 == null || e1 == null || h2 == null || e2 == null) {
            return null;
        }

        if (e1 == e2) {
            LinkedNode cur1 = h1;
            LinkedNode cur2 = h2;
            int n = 0;

            while (cur1.next != e1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != e2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? h1 : h2;
            cur2 = cur1 == h1 ? h2 : h1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            LinkedNode cur = e1.next;
            while (cur != e1) {
                if (cur == e2) {
                    return e1;
                }
                cur = cur.next;
            }
            return null;
        }
    }

    @Test
    public void testBothLoopFirstCommonNode() {
        LinkedNode n0, n1, n2, n3, n4, n5, n6, n7;
        LinkedNode h1 = n0 = new LinkedNode(0, n1 = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3,
                n4 = new LinkedNode(4, new LinkedNode(5, n6 = new LinkedNode(6,
                        n7 = new LinkedNode(7))))))));
        n7.next = n1;

//        LinkedNode h2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, n3 = new LinkedNode(3))));
//        n3.next = n4;

//        LinkedNode h2 = n0 = new LinkedNode(0);
//        n0.next = n1;

        LinkedNode h2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, n5 = new LinkedNode(5))))));
        n5.next = n6;

        LinkedNode e1 = getLoopLinkedNode(h1);
        LinkedNode e2 = getLoopLinkedNode(h2);
        LinkedNode commonNode = bothLoopFirstCommonNode(h1, e1, h2, e2);
        System.out.println(commonNode);
    }


    public static LinkedNode noLoopFirstCommonNode(LinkedNode h1, LinkedNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }

        LinkedNode cur1 = h1;
        LinkedNode cur2 = h2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? h1 : h2;
        cur2 = cur1 == h1 ? h2 : h1;
        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    @Test
    public void testNoLoopFirstCommonNode() {
        LinkedNode n1, n2;
        LinkedNode h1 = new LinkedNode(1, new LinkedNode(2, n1 = new LinkedNode(3)));
        LinkedNode h2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3,
                n2 = new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, new LinkedNode(7))))))));
//        n1.next = n2;
        LinkedNode commonNode = noLoopFirstCommonNode(h1, h2);
        System.out.println(commonNode);
    }


    public static LinkedNode getLoopLinkedNode(LinkedNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        LinkedNode fast = head;
        LinkedNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != null && fast.next != null && fast != slow);

        if (fast == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }


    @Test
    public void testGetLoopLinkedNode() {
        LinkedNode n1, n2;
        LinkedNode head = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3,
                n1 = new LinkedNode(4, new LinkedNode(5, new LinkedNode(6,
                        n2 = new LinkedNode(7))))))));
//        n2.next = n1;
        LinkedNode loopEntryNode = getLoopLinkedNode(head);
        System.out.println(loopEntryNode);
    }


    public static class LinkedNode {
        int val;
        LinkedNode next;

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
                    '}';
        }
    }


    // ===============================================

    @Test
    public void testBst2Deque() {
        Node root = new Node(6,
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(5)),
                new Node(7,
                        null,
                        new Node(9,
                                new Node(8),
                                null)));

        inOrder(root);
//        Node node = bst2Deque(root);
//        root = null;
        Node node = bst2DequeRecursive(root);
        System.out.println(node);
    }


    static class ReturnType {
        Node left;
        Node right;

        public ReturnType(Node start, Node right) {
            this.left = start;
            this.right = right;
        }

        @Override
        public String toString() {
            return "ReturnType{" +
                    "start=" + left +
                    ", end=" + right +
                    '}';
        }
    }

    public static Node bst2DequeRecursive(Node root) {
        ReturnType ret = doBst2DequeRecursive(root);
        return ret.left;
    }

    public static ReturnType doBst2DequeRecursive(Node root) {
        if (root == null) {
            return new ReturnType(null, null);
        }

        ReturnType leftRet = doBst2DequeRecursive(root.left);
        ReturnType rightRet = doBst2DequeRecursive(root.right);
        if (leftRet.right != null) {
            leftRet.right.right = root;
        }
        if (rightRet.left != null) {
            rightRet.left.left = root;
        }
        root.left = leftRet.right;
        root.right = rightRet.left;

        return new ReturnType(leftRet.left != null ? leftRet.left : root, rightRet.right != null ? rightRet.right : root);
    }

    public static Node bst2Deque(Node root) {
        Queue<Node> queue = new LinkedList<>();
        inOrder2Queue(root, queue);
        if (queue.isEmpty()) {
            return root;
        }

        Node head = queue.poll();
        Node pre = head;
        pre.left = null;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }

        pre.right = null;

        return head;
    }

    public static void inOrder2Queue(Node root, Queue<Node> queue) {
        if (root == null) {
            return;
        }

        inOrder2Queue(root.left, queue);
        queue.offer(root);
        inOrder2Queue(root.right, queue);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }


    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== list or tree =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/


    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== offer =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    // TODO 1. 迭代的加入stack中  2. 将还有parent的treeNode变成双向队列
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void getTreeNodePath(TreeNode root, TreeNode t1, Stack<TreeNode> stack) {
        stack.add(root);
        TreeNode cur = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (cur != t1) {
            cur = root.left;
            cur = root.right;
        }
        if (root == t1) {
            return;
        }
        getTreeNodePath(root.left, t1, stack);
        getTreeNodePath(root.right, t1, stack);
        stack.pop();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        return null;
    }


    public static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null || root == t1 || root == t2) {
            return root;
        }

        TreeNode left = lowestCommonAncestorRecursive(root.left, t1, t2);
        TreeNode right = lowestCommonAncestorRecursive(root.right, t1, t2);
        return left == null ? right : right == null ? left : root;
    }

    @Test
    public void testLowestCommonAncestorRecursive() {
        TreeNode t1 = null, t2 = null;
        TreeNode root = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(6,
                                new TreeNode(5),
                                new TreeNode(7))),
                new TreeNode(10,
                        t1 = new TreeNode(9),
                        t2 = new TreeNode(11)));

        TreeNode ancestor = lowestCommonAncestorRecursive(root, t1, t2);
        System.out.println(ancestor);
    }


    public static TreeNode lowestCommonAncestorWithParent(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        TreeNode n1 = t1, n2 = t2;
        while (n1 != n2) {
            n1 = n1.parent == null ? t2 : n1.parent;
            n2 = n2.parent == null ? t1 : n2.parent;
        }

        return n1;
    }


    @Test
    public void testLowestCommonAncestorWithParent() {
        TreeNode t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
        TreeNode root = t8 = new TreeNode(8,
                t4 = new TreeNode(4,
                        t2 = new TreeNode(2,
                                t1 = new TreeNode(1),
                                t3 = new TreeNode(3)),
                        t6 = new TreeNode(6,
                                t5 = new TreeNode(5),
                                t7 = new TreeNode(7))),
                t10 = new TreeNode(10,
                        t9 = new TreeNode(9),
                        t11 = new TreeNode(11)));
        t1.parent = t3.parent = t2;
        t5.parent = t7.parent = t6;
        t2.parent = t6.parent = t4;
        t9.parent = t11.parent = t10;
        t4.parent = t10.parent = t8;

        TreeNode ancestor = lowestCommonAncestorWithParent(root, t1, t9);
        System.out.println(ancestor);
    }


    public static TreeNode lowestCommonAncestor4BinarySearchTree(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        if (root.val > t1.val && root.val > t2.val) {
            return lowestCommonAncestor4BinarySearchTree(root.left, t1, t2);
        } else if (root.val < t1.val && root.val < t2.val) {
            return lowestCommonAncestor4BinarySearchTree(root.right, t1, t2);
        } else {
            return root;
        }
    }

    @Test
    public void testLowestCommonAncestorBinarySearchTree() {
        TreeNode t1 = null, t2 = null;
        TreeNode root = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(6,
                                new TreeNode(5),
                                new TreeNode(7))),
                new TreeNode(10,
                        new TreeNode(9),
                        new TreeNode(11)));

        TreeNode ancestor = lowestCommonAncestor4BinarySearchTree(root, t1, t2);
        System.out.println(ancestor);
    }


    public static class Str2Int {
        static int status;  // 0:正常 -1:非法输入

        public static int str2Int(String s) {
            status = -1;
            long num = 0;
            if (s != null && !"".equals(s)) {
                char[] ca = s.toCharArray();
                int length = ca.length;
                int idx = 0;
                boolean isNegative = false;
                if (ca[idx] == '+') {
                    idx++;
                } else if (ca[idx] == '-') {
                    isNegative = true;
                    idx++;
                }

                if (idx != length) {
                    while (idx != length) {
                        char c = ca[idx];
                        if (c >= '0' && c <= '9') {
                            int val = c - '0';
                            num = num * 10 + (isNegative ? -val : val);
                            if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
                                num = 0;
                                break;
                            }
                            idx++;
                        } else {
                            num = 0;
                            break;
                        }
                    }
                    if (idx == length) {
                        status = 0;
                    }
                }
            }
            return (int) num;
        }
    }

    @Test
    public void testStr2Int() {
        String[] sa = {
                "", null,   // status = -1; return = 0
                "+", "-",   // status = -1; return = 0
                "" + (1L + Integer.MAX_VALUE), "" + (-1L + Integer.MIN_VALUE),  // status = -1; return = 0
                "" + Integer.MAX_VALUE, "" + Integer.MIN_VALUE, // status = 0; max, min
                "1", "-1", "0"};    // status = 0; 1, -1, 0

        for (String s : sa) {
            int ret = Str2Int.str2Int(s);
            System.out.println(String.format("s = %s, status = %d, return = %d", s, Str2Int.status, ret));
        }
    }

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== offer =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/


    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== bitwise =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    public static int onceNum(int[] a, int k) {
        int res = 0;
        int intLength = 32;
        int[] bitwiseArr = new int[intLength];
        for (int i : a) {
            for (int j = 0; j < intLength; j++) {
                bitwiseArr[j] += ((i >>> j) & 1);
            }
        }

        for (int i = 0; i < intLength; i++) {
            bitwiseArr[i] %= k;
            res ^= (bitwiseArr[i] << i);
        }

        return res;
    }

    @Test
    public void testOnceNum() {
        int[][] m = {
                {1, 1, 1, 2, 2, 2, 11, 3, 11, 11, 22, 22, 22},      // k=3, 3
                {1, 1, 1, 1, 22, 22, 22, 5, 22, 2, 2, 2, 2, 4, 4, 4, 4},// k=4, 5
                {22, 22, 44, -10, 44, -1, -1, -2, -2},          // k=2, -10
                {1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 5, -1, 4, 3, 2, 1, 1, 2, 3, 4, 5},    // k=5, -1
        };

        int[] a = {3, 4, 2, 5};
        for (int i = 0; i < a.length; i++) {
            System.out.println(onceNum(m[i], a[i]));
        }
    }

    // =============================================================================
    public static void printOddTimesNum2(int[] a) {
        int xor = 0;
        for (int i : a) {
            xor ^= i;
        }

//        int xorHasOne = xor & (~xor + 1); // (~xor + 1) <==> (-xor)
        int xorHasOne = xor & (-xor);
        int one = 0;
        int two;
        for (int i : a) {
            if ((i & xorHasOne) != 0) {
                one ^= i;
            }
        }

        two = xor ^ one;
        System.out.println(one + ", " + two);
    }


    @Test
    public void testOddTimeNum2() {
        int[][] m = {
                {1, 1, 2, 2, 3, 4},                 // 3,   4
                {10, 10, 22, 23, 33, 33, 23, 24},   // 22,  24
                {11, 22, 33, 22, 11, 44},           // 33,  44
                {0, -1, -2, -3, -2, -1, 0, -4},     // -3,  -4
                {0, 1, 1, -1, -1, 22},              // 0,   22
        };

        for (int[] a : m) {
            printOddTimesNum2(a);
        }

    }


    public static void printOddTimesNum1(int[] a) {
        int xor = 0;
        for (int i : a) {
            xor ^= i;
        }
        System.out.println(xor);
    }

    @Test
    public void testOddTimeNum1() {
        int[][] m = {
                {1, 1, 2, 2, 3},                // 3
                {10, 10, 22, 23, 33, 33, 23},   // 22
                {11, 22, 33, 22, 11},           // 33
                {0, -1, -2, -3, -2, -1, 0},     // -3
                {0, 1, 1, -1, -1},              // 0
        };

        for (int[] a : m) {
            printOddTimesNum1(a);
        }

    }


    // ==========================================================================

    public static int countIII(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    public static int countII(int n) {
        int res = 0, mask = 1;
        while (mask != 0) {
            if ((n & mask) != 0) {
                res++;
            }
            mask = mask << 1;
        }
        return res;
    }

    public static int countI(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    @Test
    public void testCount() {
        int[] a = {1, 0, -1, 7, 8, 15, 16};
        for (int i : a) {
//            System.out.println(countI(i));
//            System.out.println(countII(i));
            System.out.println(countIII(i));
        }
    }


    public static int oppositeNum(int a) {
        return add(~a, 1);
    }


    // ==========================================================================

    public static int addIIRecursive(int a, int b) {
        return b == 0 ? a : addIIRecursive(a ^ b, (a & b) << 1);
    }

    public static int addII(int a, int b) {
        int t;
        while (b != 0) {
            t = (a & b) << 1;
            a = a ^ b;
            b = t;
        }
        return a;
    }

    // ==========================================================================
    public static int addRecursive(int a, int b) {
        return a == 0 ? b : addRecursive((a & b) << 1, a ^ b);
    }

    public static int add(int a, int b) {
        int t;
        while (a != 0) {
            t = (a & b) << 1;
            b = a ^ b;
            a = t;
        }
        return b;
    }
    // ==========================================================================

    public static int sub(int a, int b) {
        return add(a, oppositeNum(b));
    }

    @Test
    public void testSum() {
        int[][] matrix = {
                {1, 3},
                {10, 0},
                {-1, 1},
                {0, 0},
                {0, 1},
                {-1, 0},
                {-1, -1}
        };
        for (int[] a : matrix) {
            System.out.print(Arrays.toString(a));
            System.out.print(": \t\t");
//            System.out.print(addRecursive(a[0], a[1]));
            System.out.print(addIIRecursive(a[0], a[1]));
            System.out.print("\t");
//            System.out.print(add(a[0], a[1]));
            System.out.print(addII(a[0], a[1]));
            System.out.print("\t");
            System.out.print(sub(a[0], a[1]));
            System.out.println();
        }
    }


    /**
     * 1和0转换
     * 输入只能是1或0: 1->0, 0->1
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    /**
     * n >= 0时, 返回1
     * n < 0时, 返回0
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    @Test
    public void testGetMax() {
        int[][] matrix = {
                {1, 3},
                {10, 0},
                {-1, 1},
                {0, 0},
                {0, 1},
                {-1, 0}
        };
        for (int[] a : matrix) {
            System.out.println(getMax(a[0], a[1]));
        }
    }


    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    @Test
    public void testSwap() {
        int[][] matrix = {
                {1, 3},
                {10, 0},
                {-1, 1},
                {0, 0},
                {0, 1},
                {-1, 0}
        };

        for (int[] a : matrix) {
            swap(a, 0, 1);
            System.out.println(Arrays.toString(a));
        }
    }

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== bitwise =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/


    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== dp =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    public static int leastSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static int leastSumPlus(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = Math.min(rows, cols);
        int max = Math.max(rows, cols);
        boolean isRows = rows < cols;

        int[] a = new int[min];
        a[0] = matrix[0][0];
        for (int i = 1; i < min; i++) {
            a[i] = a[i - 1] + (isRows ? matrix[0][i] : matrix[i][0]);
        }

        for (int i = 1; i < max; i++) {
            a[0] = a[0] + (isRows ? matrix[i][0] : matrix[0][i]);
            for (int j = 1; j < min; j++) {
                a[j] = Math.min(a[j], a[j - 1]) + (isRows ? matrix[i][j] : matrix[j][i]);
            }
        }

        return a[min - 1];
    }

    @Test
    public void testLeastSum() {
        int[][] matrix = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };

        System.out.println(leastSum(matrix));
        System.out.println(leastSumPlus(matrix));
    }

    // ===============================================================================================

    public static int walk(int N, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }

        if (cur == 1) {
            return walk(N, 2, rest - 1, p);
        } else if (cur == N) {
            return walk(N, N - 1, rest - 1, p);
        } else {
            return walk(N, cur + 1, rest - 1, p) + walk(N, cur - 1, rest - 1, p);
        }
    }

    public static int ways1(int N, int cur, int rest, int p) {
        if (N < 2 || cur < 1 || cur > N || rest < 1 || p < 1 || p > N) {
            return 0;
        }
        return walk(N, cur, rest, p);
    }

    public static int ways2(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N) {
            return 0;
        }

        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }

        return dp[K][M];
    }

    public static int ways3(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N) {
            return 0;
        }

        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i <= K; i++) {
            int leftUp = dp[1];
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[2];
                } else if (j == N) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = tmp;
            }
        }
        return dp[M];
    }


    @Test
    public void testWays() {
        int[][] aa = {
                {5, 2, 3, 3},   // 3
                {3, 1, 3, 3}    // 0
        };

        for (int[] a : aa) {
//            int cnt = ways1(a[0], a[1], a[2], a[3]);
//            int cnt = ways2(a[0], a[1], a[2], a[3]);
            int cnt = ways3(a[0], a[1], a[2], a[3]);
            System.out.println(cnt);
        }
    }

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== dp =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/


    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== dfs/bfs =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== dfs/bfs =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/
}
