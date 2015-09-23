package com.coder.alg.string.LongestSubstring;

import java.util.Arrays;

/**
 * Created by xuyue on 15/9/16.
 */
public class LongestSubstring {

    private static int[] toIntArray(String input) {
        int N = input.length();
        int[] result = new int[N];
        for (int i = 0; i < N; ++i) {
            result[i] = input.charAt(i) - '0';
        }
        return result;
    }

    private static int findLength(int[] a) {
        int N = a.length;
        int maxlen = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; j += 2) {
                int len = j - i + 1;
                int leftsum = 0, rightsum = 0;
                for (int k = 0; k < len / 2; ++k) {
                    leftsum += a[i + k];
                    rightsum += a[i + k + len / 2];
                }
                if (leftsum == rightsum && len > maxlen)
                    maxlen = len;
            }
        }
        return maxlen;
    }

    private static int findLength2(int[] a) {
        int maxlen = 0;
        int N = a.length;
        int[][] sum = new int[N][N];

        for (int i = 0; i < N; ++i) {
            sum[i][i] = a[i];
        }

        for (int len = 2; len <= N; ++len) {
            for (int i = 0; i < N - len + 1; ++i) {
                int j = i + len - 1;
                int k = len / 2;
                sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];
                if (len % 2 == 0 && sum[i][j - k] == sum[j - k + 1][j] && len > maxlen)
                    maxlen = len;
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String input = "153803";
        int[] a = toIntArray(input);
        System.out.println(Arrays.toString(a));
        int len = findLength2(a);
        System.out.println(len);
    }
}
