package com.coder.alg.dynamicProgramming;

/**
 * Created by xuyue on 15/9/13.
 */
public class LCS {

    private static int[][] remember = new int[100][100];

    public static int lcs_length(String x, String y){
        if (x == null || y == null)
            return 0;

        char[] xChar = x.toCharArray();
        char[] yChar = y.toCharArray();
        int N = xChar.length;
        int M = yChar.length;

        for (int i=1; i <= N; ++i)
            remember[i][0] = 0;
        for (int i=1; i <= M; ++i)
            remember[0][i] = 0;
        remember[0][0] = 0;

        for (int i=1; i <= N; ++i){
            for (int j=1; j <= M; ++j){
                if (xChar[i-1] == yChar[j-1])
                    remember[i][j] = remember[i-1][j-1] + 1;
                else
                    remember[i][j] = Math.max(remember[i-1][j], remember[i][j-1]);
            }
        }

        return remember[N][M];
    }

    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BDCABA";
        int lcs = LCS.lcs_length(a, b);
        System.out.println(lcs);
    }

}