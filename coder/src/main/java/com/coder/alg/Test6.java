package com.coder.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by xuyue on 15/9/21.
 */
public class Test6 {

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
        int[] pid = new int[N];
        int[][] holdlocks = new int[N][];
        int[] needlocks = new int[N];
        Proess[] proesses = new Proess[N];

        HashMap<Integer, Integer> holdprocess = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; ++i) {
            String[] tmp = input[i].split("\\t");
            pid[i] = Integer.parseInt(tmp[0]);
            String[] tmpLocks = tmp[1].split(",");
            holdlocks[i] = new int[tmpLocks.length];
            for (int j=0; j < tmpLocks.length; ++j){
                holdlocks[i][j] = Integer.parseInt(tmpLocks[j]);
                holdprocess.put(holdlocks[i][j], pid[i]);
            }
            needlocks[i] = tmp[2] == " " ? 0 : Integer.parseInt(tmp[2]);
            proesses[i] = new Proess(pid[i], holdlocks[i], needlocks[i]);


        }



        for (int i = 0; i < N; ++i){
            int currentpid = pid[i];
            int lockNum = holdlocks[i].length;
            for (int j= 0; j < lockNum; ++j){
                int lock = holdlocks[i][j];
            }
        }



    }

    static class Proess{
        int pid;
        int[] holdlocks;
        int needlock;

        public Proess(int pid, int[] holdlocks, int needlock) {
            this.pid = pid;
            this.holdlocks = holdlocks;
            this.needlock = needlock;
        }
    }


}
