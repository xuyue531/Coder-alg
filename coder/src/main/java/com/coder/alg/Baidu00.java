package com.coder.alg;

import java.util.ArrayList;

/**
 * given: a group of int numbers.
 * <p/>
 * output: all possible combinations of characters
 * while the character's order in alphbet is the same
 * with the int numbers.
 * <p/>
 * example:  giver {1, 2, 3}
 * output:  then output :"abc", "aw", "lc" (l is 12th char in alphbet, w is 23rd).
 */
public class Baidu00 {

    private char[] perm;
    private int[] arr;

    public Baidu00(int[] arr) {
        this.arr = arr;
        this.perm = new char[arr.length];
    }

    private char convertIntToChar(int intVal) {
        int temp = 'a' + intVal - 1;
        return (char) temp;
    }

    public void printStringsCombine(int pos, int permPos) {
        if (pos == arr.length) {
            for (int i = 0; i < permPos; i++) {
                System.out.print(perm[i]);
            }
            System.out.println("");
            return;
        }

        perm[permPos] = convertIntToChar(arr[pos]);
        printStringsCombine(pos + 1, permPos + 1);

        if (pos + 1 < arr.length && arr[pos] * 10 + arr[pos + 1] <= 26) {
            perm[permPos] = convertIntToChar(arr[pos] * 10 + arr[pos + 1]);
            printStringsCombine(pos + 2, permPos + 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Baidu00 test = new Baidu00(arr);
        test.printStringsCombine(0, 0);


        System.out.println("=========");
        ArrayList<Integer> l = new ArrayList<Integer>();

        l.add(2);
        l.add(23);
        l.add(3);
        for (int a : l) {
            System.out.println(a);
        }
        System.out.println("=========");
        l.set(0, 12);
        for (int a : l) {
            System.out.println(a);
        }
    }


}
