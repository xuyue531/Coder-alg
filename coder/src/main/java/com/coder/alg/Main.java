package com.coder.alg;

import java.util.Scanner;

/**
 * Created by xuyue on 15/9/19.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] firstLine = line.split(" ");
            int[] input = new int[firstLine.length];
            for (int i = 0; i < firstLine.length; ++i) {
                input[i] = Integer.parseInt(firstLine[i]);
            }
            int moTime = input[0];
            int guTime = input[1];
            int left = input[2];
            int right = input[3];
            int[][] mo = new int[moTime][2];
            int[][] gu = new int[guTime][2];
            for (int i = 0; i < moTime; i++) {
                line = in.nextLine();
                String[] tmp = line.split(" ");
                mo[i][0] = Integer.parseInt(tmp[0]);
                mo[i][1] = Integer.parseInt(tmp[1]);
            }
            for (int i = 0; i < guTime; i++) {
                line = in.nextLine();
                String[] tmp = line.split(" ");
                gu[i][0] = Integer.parseInt(tmp[0]);
                gu[i][1] = Integer.parseInt(tmp[1]);
            }
            int[][] upTime = new int[moTime*guTime][2];
            for (int i = 0; i < moTime; ++i){
                for (int j = 0; j < guTime; ++j){
                    int begin = mo[i][0] - gu[j][1];
                    int end = mo[i][1] - gu[j][0];
                    upTime[i+j][0] = begin;
                    upTime[i+j][1] = end;
                }
            }
            int result = 0;
            for (int i = 0; i < moTime*guTime; ++i){
                int begin = upTime[i][0];
                int end = upTime[i][1];
                for (int j = i+1; j < moTime*guTime; ++j){
                    if (end < upTime[j][0] || begin > upTime[j][1]){
                        result += begin+end;
                    }else if (begin > upTime[j][1] && end < upTime[j][0]){
                        result += end - begin;
                        upTime[j][0] = 0;
                        upTime[j][1] = 0;
                    }else if (begin > upTime[j][0] &&  end < upTime[j][0]){
                        result += end-begin;
                        upTime[j][0] += begin;
                    }else if (begin > upTime[j][1] && end < upTime[j][1]){
                        result += end - begin;
                        upTime[j][1] -= end;
                    }
                }
            }
            System.out.println(result);
        }


    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String line;
//        while (in.hasNextLine()){
//            line = in.nextLine();
//            String[] firstLine = line.split(" ");
//            int[] input = new int[firstLine.length];
//            for (int i = 0; i < firstLine.length; ++i){
//                input[i] = Integer.parseInt(firstLine[i]);
//            }
//            int basket = input[0];
//            int ballNum = input[1];
//            int[] balls = new int[ballNum];
//            for (int j = 0; j < ballNum; ++ j){
//                balls[j] = Integer.parseInt(in.nextLine());
//            }
//            int[] shot = new int[ballNum];
//            for (int k = 0; k < ballNum; ++k){
//                int mod = balls[k]%basket;
//                if (shot[mod] != 0){
//                    System.out.println(k);
//                }else if (shot[mod] == 0){
//                    shot[mod] = 1;
//                }
//            }
//            System.out.println(-1);
//        }
//    }
}
