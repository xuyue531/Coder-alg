package com.coder.alg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by xuyue on 15/9/21.
 */
public class Test5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        int N = 0;
        if (in.hasNextLine()) {
            N = Integer.parseInt(in.nextLine());
        }
        String[] input = new String[N];
        for (int i = 0; i < N; ++i) {
            line = in.nextLine();
            input[i] = line;
        }
        Arrays.sort(input, new VersionComparator());
        for (int i = input.length-1; i >= 0; --i) {
            String version = input[i];
            String[] tmp = version.split("\\.");
            int minor = Integer.parseInt(tmp[1]);
            if (minor %2 == 0){
                System.out.println(version);
                return;
            }
        }
        System.out.println("no stable available");
    }


    static class VersionComparator implements Comparator<String> {

        @Override
        public int compare(String v1, String v2) {
            int a1 = 0, a2 = 0, a3 = 0;
            int b1 = 0, b2 = 0, b3 = 0;
            String[] tmp = v1.split("\\.");
            a1 = Integer.parseInt(tmp[0]);
            a2 = Integer.parseInt(tmp[1]);
            if (tmp.length > 2)
                a3 = Integer.parseInt(tmp[2]);
            tmp = v2.split("\\.");
            b1 = Integer.parseInt(tmp[0]);
            b2 = Integer.parseInt(tmp[1]);
            if (tmp.length > 2)
                b3 = Integer.parseInt(tmp[2]);
            if (a1 > b1) {
                return 1;
            } else if (a1 < b1) {
                return -1;
            } else {
                if (a2 > b2) {
                    return 1;
                } else if (a2 < b2) {
                    return -1;
                } else {
                    if (a3 > b3) {
                        return 1;
                    } else if (a3 < b3) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }


}
