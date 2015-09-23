package com.coder.alg.sort.Bubble;

import java.util.Arrays;

/**
 * Created by xuyue on 15/9/15.
 */
public class Bubble {

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void bubbleSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; ++i)
            for (int j = 0; j < N - i - 1; ++j)
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
    }

    private static void bubbleSort2(int[] a) {
        int N = a.length;
        boolean flag = false;
        for (int i = 0; i < N - 1; ++i){
            for (int j = 0; j < N - i - 1; ++j)
                if (a[j] > a[j + 1]){
                    swap(a, j, j + 1);
                    flag = true;
                }
            if (flag)
                break;
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 9, 2, 3, 6, 3, 5, 12, 1};
        Bubble.bubbleSort2(a);
        System.out.println(Arrays.toString(a));
    }

}
