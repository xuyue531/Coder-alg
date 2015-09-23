package com.coder.alg.sort.Selection;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xuyue on 15/9/15.
 */
public class Selection {

    private static void selectionSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; ++i) {
            int min = i;
            int j;
            for (j = i + 1; j < N; ++j) {
                if (a[j] < a[min])
                    min = j;
            }
            swap(a, i, min);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = 0;
        if (in.hasNextLine()) {
            nums = Integer.parseInt(in.nextLine());
        }
        while (nums > 0 && in.hasNextLine()) {
            String line = in.nextLine();
            String[] tmp = line.split(" +");
            int[] input = new int[tmp.length];
            for (int i = 0; i < tmp.length; ++i) {
                input[i] = Integer.parseInt(tmp[i]);
            }
            selectionSort(input);
            System.out.println(Arrays.toString(input));
            --nums;
        }
    }


}
