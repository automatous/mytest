package com.example.demo.alg;

import org.junit.Test;

public class LinkedNodeTest {

    static class LinkedNode {
        int value;
        LinkedNode next;

        public LinkedNode(int value, LinkedNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }


    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    static class TreeNodeHelper {
        static TreeNode head;
        static TreeNode pre;
    }


    // =========================== 两个链表的第一个公共结点 =================================
    public static LinkedNode findFirstCommonNode(LinkedNode h1, LinkedNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }
        LinkedNode n1 = h1, n2 = h2;
        int i1 = 0, i2 = 0;
        while (i1 <= 1 && i2 <= 1 && n1 != n2) {
            if (n1 == null) {
                i1++;
                n1 = h2;
            } else {
                n1 = n1.next;
            }

            if (n2 == null) {
                i2++;
                n2 = h1;
            } else {
                n2 = n2.next;
            }
        }
        if (i1 > 1 || i2 > 1) {
            n1 = null;
        }
        return n1;
    }

    @Test
    public void testFindFirstCommonNode() {
        LinkedNode c = new LinkedNode(101, new LinkedNode(102, new LinkedNode(103, new LinkedNode(104, null))));
//        c = null;
        LinkedNode a = new LinkedNode(1, new LinkedNode(2, c));
        LinkedNode b = new LinkedNode(11, new LinkedNode(12, new LinkedNode(13, new LinkedNode(14, c))));
        LinkedNode commonNode = findFirstCommonNode(a, b);
        System.out.println(commonNode);
    }
    // =========================== 两个链表的第一个公共结点 =================================

    // ================================= 二叉搜索树与双向链表 ==========================================
    public static TreeNode tree2Linked(TreeNode head) {
        if (head == null) {
            return null;
        }
        inOrder(head);
        return TreeNodeHelper.head;
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        head.left = TreeNodeHelper.pre;
        if (TreeNodeHelper.pre != null)
            TreeNodeHelper.pre.right = head;
        TreeNodeHelper.pre = head;
        if (TreeNodeHelper.head == null)
            TreeNodeHelper.head = head;
        inOrder(head.right);
    }

    public static void inOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.println(head.value);
        inOrderPrint(head.right);
    }

    @Test
    public void testTree2Linked() {
        TreeNode head = new TreeNode(4,
                new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
                new TreeNode(5, null, null));
        TreeNode treeNode = tree2Linked(head);
        System.out.println(treeNode);

//        inOrderPrint(head);
    }
    // ================================= 二叉搜索树与双向链表 ==========================================
}
