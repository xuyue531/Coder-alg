package com.coder.alg.sort.Quick;

/**
 * Created by xuyue on 15/9/19.
 */
public class Quick2 {

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partation(a, low, high);
            quickSort(a, pivot + 1, high);
            quickSort(a, low, pivot - 1);
        }
    }

    private static int partation(int[] a, int low, int high) {
        int x = a[high];
        int i = low - 1;
        for (int j = low; j < high; ++j) {
            if (a[j] <= x) {
                ++i;
                exchange(a, i, j);
            }
        }
        exchange(a, i + 1, high);
        return i + 1;
    }

    private static void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
