package com.coder.alg;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xuyue on 15/9/19.
 */
public class Test4 {

    public int[] soultion(int[][] a, int n){
        ArrayList<Integer> result = new ArrayList<Integer>(n*n);
        for (int row = 0; row < n; ++row) {
            int cols = 0;
            if (row == 0) {
                cols = n - 1;
            }
            for (int column = cols; column >= 0; --column) {
                int concatCount = (n - row) - column;
                for (int line = 0; line < concatCount; ++line) {
                    result.add(a[row+line][column+line]);
                }
            }
        }
        int[] output = new int[n*n];
        for (int i = 0; i < result.size(); ++i){
            output[i] = result.get(i);
        }
        return output;
    }


    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] result = test4.soultion(a, 4);
        System.out.println(Arrays.toString(result));
    }

}
