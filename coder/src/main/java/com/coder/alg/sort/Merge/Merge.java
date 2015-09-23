package com.coder.alg.sort.Merge;

import com.coder.alg.sort.BaseSort;

import java.util.Arrays;

public class Merge extends BaseSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        mergeSort(a, 0, N-1);
    }

    private static void mergeSort(Comparable[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        for (k = low; k <= high; ++k) {
            aux[k] = a[k];
        }
        for (k = low; i <= mid && j <= high;) {
            System.out.println("a is " + a[i] + ", b is " + a[j] + ", compare is " + less(a[i], a[j]));
            if (less(a[i], a[j]))
                a[k++] = aux[i++];
            else
                a[k++] = aux[j++];
        }
        while (i <= mid) a[k++] = aux[i++];
        while (j <= high) a[k++] = aux[j++];
    }

    public static void main(String[] args) {
        Integer[] input = {1, 2, 7, 3, 2, 5};
        Merge.sort(input);
        System.out.println(Arrays.toString(input));
    }

}
