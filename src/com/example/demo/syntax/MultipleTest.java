package com.example.demo.syntax;

import org.junit.Test;

import java.util.Arrays;

public class MultipleTest {

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int arr[], int start, int end) {
        int idx = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                idx++;
                if (i != idx) {
                    swap(arr, i, idx);
                }
            }
        }
        idx++;
        swap(arr, idx, end);
        return idx;
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }


    @Test
    public void testQuickSort() {
//        int arr[] = {3, 9, 8, 2, 1, 0};
        int arr[] = { 1, 0, 3, 9, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
