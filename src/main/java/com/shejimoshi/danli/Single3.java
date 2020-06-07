/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package com.shejimoshi.danli;

/**
 * @FileName: Single3.java
 * @Description: Single3.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/5 21:27
 */
public class Single3 {
    private static class Sun{
        private static final Single3 INSTANCE = new Single3();
    }
    private Single3(){}
    public static Single3 getInstance(){
        return Sun.INSTANCE;
    }
}
