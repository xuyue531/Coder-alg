package com.coder.alg;

/**
 * Created by xuyue on 15/9/23.
 */
public class GCTest {

    private B b;


    public GCTest() {
        b = new B();
    }


    public static void main(String[] args) {
        GCTest test = new GCTest();
        System.gc();
        test = null;
//        System.gc();
    }
}
