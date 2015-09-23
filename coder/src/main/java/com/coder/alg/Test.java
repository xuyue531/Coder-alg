package com.coder.alg;

/**
 * Created by xuyue on 15/9/19.
 */
public class Test {

    public int limitedMaxSum(int[] arr, int length, int limit) {
        int max = 0;
        for (int i = 0; i < length; ++i){
            for (int j = i; j < length; ++j){
                int a = arr[i];
                int b = arr[j];
                int s = a+b;
                if (s <= limit && s > max){
                    max = s;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Test test = new Test();
        int[] a = {1};
        int result = test.limitedMaxSum(a, 1, 2);
        System.out.println(result);
    }

}
