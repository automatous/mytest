package com.example.demo.alg;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TempTest {


    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


    static class LinkedNode {
        int val;
        LinkedNode next;

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


    // ================================ select sort ========================================
    public static LinkedNode selectSort(LinkedNode head) {
        LinkedNode newHead = null;
        LinkedNode tail = null;
        LinkedNode cur = head;
        while (cur != null) {
            LinkedNode minNode = cur;
            LinkedNode preMinNode = preMinNode(cur);
            if (preMinNode != null) {
                minNode = preMinNode.next;
                preMinNode.next = preMinNode.next.next;
            }

            if (tail != null) {
                tail.next = minNode;
            } else {
                newHead = minNode;
            }

            tail = minNode;
            cur = minNode == cur ? cur.next : cur;
        }

        return newHead;
    }

    public static LinkedNode preMinNode(LinkedNode node) {
        LinkedNode preNode = null;
        LinkedNode cur = node;
        if (cur != null) {
            int min = cur.val;
            LinkedNode pre = cur;
            cur = cur.next;
            while (cur != null) {
                if (min > cur.val) {
                    min = cur.val;
                    preNode = pre;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        return preNode;
    }

    static void printLinkedNode(LinkedNode head) {
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

    @Test
    public void testSelectSort() {
//        LinkedNode head = new LinkedNode(3, new LinkedNode(9, new LinkedNode(8, new LinkedNode(2, new LinkedNode(1, new LinkedNode(0, null))))));
        LinkedNode head = new LinkedNode(1, new LinkedNode(0, new LinkedNode(3, new LinkedNode(9, new LinkedNode(8, new LinkedNode(2, null))))));
        LinkedNode newHead = selectSort(head);
        printLinkedNode(newHead);
    }



    // =============================== insert sort ===================================
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int p = arr[i];
            while (j >= 0 && arr[j] > p) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = p;
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {3, 9, 8, 2, 1, 0};
//        int[] arr = {1, 0, 3, 9, 8, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    // ================================== merge sort ===================================
    public static void mergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length);
    }

    public static void mergeSort(int[] arr, int[] aux, int l, int r) {
        if (r - l <= 1) {
            return;
        }

        int m = l + (r - l) / 2;
        mergeSort(arr, aux, l, m);
        mergeSort(arr, aux, m, r);

        merge(arr, aux, l, m, r);
    }

    public static void merge(int[] arr, int[] aux, int l, int m, int r) {
        int i = l, j = m;
        for (int k = l; k < r; k++) {
            if (i == m) {
                aux[k] = arr[j++];
            } else if (j == r) {
                aux[k] = arr[i++];
            } else if (arr[i] < arr[j]) {
                aux[k] = arr[i++];
            } else {
                aux[k] = arr[j++];
            }
        }

        for (int k = l; k < r; k++) {
            arr[k] = aux[k];
        }
    }

    @Test
    public void testMergeSort() {
//        int[] arr = {3, 9, 8, 2, 1, 0};
        int[] arr = {1, 0, 3, 9, 8, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // =============================== quick sort =================================
    public static int partition(int[] a, int lo, int hi) {
        int idx = lo - 1;
        int p = a[hi];
        for (int i = lo; i < hi; i++) {
            if (a[i] < p) {
                idx++;
                if (i != idx) {
                    swap(a, i, idx);
                }
            }
        }

        idx++;
        swap(a, idx, hi);

        return idx;
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);
            quickSort(a, start, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }


    @Test
    public void testQuickSort() {
        int[] arr = {3, 9, 8, 2, 1, 0};
//        int[] arr = { 1, 0, 3, 9, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}