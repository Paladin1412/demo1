/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @FileName: Test01.java
 * @Description: Test01.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/21 11:42
 */
public class Test01 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        BlockingQueue<Integer> linkedQueue = new LinkedBlockingQueue<>();


    }
}
