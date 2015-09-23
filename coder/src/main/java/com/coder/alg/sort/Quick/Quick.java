package com.coder.alg.sort.Quick;

import java.util.Arrays;

public class Quick {

    public static void sort(int[] a) {
        int N = a.length;
        quickSort(a, 0, N - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partation(a, low, high);
//            int pivot = partation2(a, low, high);
//            int pivot = randomPartation(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    private static int partation(int[] a, int low, int high) {
        int pivot = a[high];
        while (low < high) {
            while (low < high && a[low] <= pivot)
                ++low;
            a[high] = a[low];
            while (low < high && a[high] >= pivot)
                --high;
            a[low] = a[high];
        }
        a[high] = pivot;
        return low;
    }

    private static int partation2(int[] a, int low, int high) {
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

//    private static int randomPartation(int[] a, int low, int high) {
//        Random random = new Random();
//        int randNum = random.nextInt(high-low);
//        exchange(a, low+randNum-1, high);
//        int pivot = partation(a, low, high);
//        return pivot;
//    }

    private static void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 7, 3, 2, 5, 1};
        sort(input);
        System.out.println(Arrays.toString(input));
    }


}
