package com.coder.alg.sort.Merge;

import java.util.Arrays;

/**
 * Created by xuyue on 15/9/12.
 */
public class Merge3 {

    public static void sort(int[] a) {
        int N = a.length;
        mergeSort(a, 0, N - 1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid, k = high;
        while (i < j && j <= k){
            int step = 0;
            while (i < j && a[i] < a[j])
                ++i;
            while (j <= k && a[j] < a[i]){
                ++j;
                ++step;
            }
            exchange(a, i, mid, j);
            i = i+step;
        }
    }

    private static void swap(int[] a, int first, int second) {
        int tmp = a[first];
        a[first] = a[second];
        a[second] = tmp;
    }

    private static void reverse(int[] a, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            swap(a, i, j);
            ++i;
            --j;
        }
    }

    private static void exchange(int[] a, int low, int mid, int high) {
        reverse(a, low, mid);
        reverse(a, mid + 1, high);
        reverse(a, low, high);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 7, 3, 2, 5};
        Merge3.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
