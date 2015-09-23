package com.coder.alg.string.AllSpaces;

/**
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 * Created by xuyue on 15/9/15.
 */
public class AllSpaces {

    private static void printPattern(String str) {
        int N = str.length();
        StringBuilder builder = new StringBuilder(2*N);
        char[] chars = str.toCharArray();
        builder.append(chars[0]);
        printPatternUtil(chars, builder, 1, N);
    }

    private static void printPatternUtil(char[] chars, StringBuilder builder, int i, int n) {
        if (i == n){
            System.out.println(builder.toString());
            return;
        }
        builder.append(chars[i]);
        printPatternUtil(chars, builder, i+1, n);
        builder.append(" ").append(chars[i]);
        printPatternUtil(chars, builder, i+1, n);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        printPattern(str);
    }
}
