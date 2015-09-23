package com.coder.alg;

/**
 * Created by xuyue on 15/9/19.
 */
public class Test3 {

    public long getNumberOfCombinations(int N) {
        int Combinations = nextCoinCombinations(N, 100);
        return Combinations;
    }

    private int nextCoinCombinations(int N, int coin) {
        int nextCoin = 0;
        switch (coin) {
            case 100:
                nextCoin = 50;
                break;
            case 50:
                nextCoin = 20;
                break;
            case 20:
                nextCoin = 10;
                break;
            case 10:
                nextCoin = 5;
                break;
            case 5:
                nextCoin = 1;
                break;
            case 1:
                return 1;
        }

        int Combinations = 0;
        for (int i = 0; i * coin <= N; ++i) {
            Combinations += nextCoinCombinations(N - i * coin, nextCoin);
        }

        return Combinations;

    }


    public static void main(String[] args) {
        Test3 test3 = new Test3();
        long result = test3.getNumberOfCombinations(17);
        System.out.println(result);
    }

}
