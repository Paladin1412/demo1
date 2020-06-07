package com.io;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        int anInt = SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2);
        System.out.println(anInt);

//        ArrayList list = new ArrayList();
//        list.
    }
}
