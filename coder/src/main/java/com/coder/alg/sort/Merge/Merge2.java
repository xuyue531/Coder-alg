package com.coder.alg.sort.Merge;

import com.coder.alg.sort.BaseSort;

import java.util.Arrays;

/**
 * Created by xuyue on 15/9/12.
 */
public class Merge2 extends BaseSort {

    private static int[] aux;

    public static void sort(int[] a){
        int N = a.length;
        aux = new int[N];
        mergeSort(a, 0, N-1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high){
            int mid = (low + high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid+1;
        int k = 0;
        for (k = low; k <= high; ++k){
            aux[k] = a[k];
        }
        k = low;
        while (i <= mid && j <= high){
            if (aux[i] < aux[j]){
                a[k++] = aux[i++];
            }else {
                a[k++] = aux[j++];
            }
        }
        while (i <= mid)
            a[k++] = aux[i++];
        while (j <= high)
            a[k++] = aux[j++];
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 7, 3, 2, 5,1 };
        Merge2.sort(input);
        System.out.println(Arrays.toString(input));
    }


}
