package com.example.demo.alg;

public class CSAIA {

    public static int binarySearch(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int lo, int hi) {
        if (hi <= lo) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0) {
            return search(key, a, lo, mid);
        } else if (cmp < 0) {
            return search(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }


    public static void mergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length);
    }

    public static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
        if (hi - lo <= 1) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid, hi);

        merge(arr, aux, lo, hi, mid);
    }

    private static void merge(int[] arr, int[] aux, int lo, int hi, int mid) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if (i == mid) {
                aux[k] = arr[j++];
            } else if (j == hi) {
                aux[k] = arr[i++];
            } else if (arr[i] <= arr[j]) {
                aux[k] = arr[i++];
            } else {
                aux[k] = arr[j++];
            }
        }

        for (int k = lo; k < hi; k++) {
            arr[k] = aux[k];
        }
    }

}
