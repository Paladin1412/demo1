/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package jvm;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @FileName: GCTest01.java
 * @Description: GCTest01.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/21 18:12
 */
public class GCTest01 {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        while (true){
            executor.execute(()->{
                while (true){
                    Integer i = new Integer(1);
                }
            });
        }
    }
}
