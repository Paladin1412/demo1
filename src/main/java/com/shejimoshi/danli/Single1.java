/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package com.shejimoshi.danli;

/**
 * @FileName: Single1.java
 * @Description: Single1.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/5 21:13
 */
public class Single1 {
    private static  Single1 INSTANCE = new Single1();
    private Single1(){}
    public static Single1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Single4.SINGLE.hashCode());
            }).start();
        }
    }
}
