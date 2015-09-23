package com.coder.alg.sort.PQ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xuyue on 15/9/15.
 */
public class HeapSort {


    private static void sort(int[] a) {
        int N = a.length-1;
        buildMaxHeap(a);
        for (int i = N; i > 1; --i) {
            swap(a, i, 1);
            adjustDown(a, 1, i-1);
        }
    }

    private static void adjustDown(int[] a, int k, int len) {
        a[0] = a[k];
        for (int i = 2 * k; i < len; i *= 2) {
            if (i < len && a[i] < a[i + 1])
                ++i;
            if (a[0] >= a[i])
                break;
            else {
                a[k] = a[i];
                k = i;
            }
        }
        a[k] = a[0];
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void buildMaxHeap(int[] a) {
        int N = a.length-1;
        for (int i = N/2; i > 0; --i)
            adjustDown(a, i, N);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        int[] input;
        int nums = 0;
        if (in.hasNextLine()){
            String s = in.nextLine();
            nums = Integer.parseInt(s);
        }
        while (nums > 0 && in.hasNextLine()){
            line = in.nextLine();
            String[] a = line.split(" +");
            input = new int[a.length+1];
            try {
                for (int i = 0; i < a.length; ++i){
                    input[i+1] = Integer.parseInt(a[i]);
                }
            }catch (ClassCastException e){
                e.printStackTrace();
            }
            HeapSort.sort(input);
            System.out.println(Arrays.toString(input));
            --nums;
        }

    }


}
