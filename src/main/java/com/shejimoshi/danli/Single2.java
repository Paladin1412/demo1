/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package com.shejimoshi.danli;

/**
 * @FileName: Single2.java
 * @Description: Single2.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/5 21:20
 */
public class Single2 {
    private static Single2 INSTANCE;
    private Single2(){}
    public static Single2 getInstance(){
        if (INSTANCE==null){
            synchronized (Single2.class){
                if(INSTANCE==null){
                    INSTANCE = new Single2();
                }
            }
        }
        return INSTANCE;
    }
}
