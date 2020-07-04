package com.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

public class Client {
    public static void main(String[] args) {
        int anInt = SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2);
        System.out.println(anInt);
    }
    public static void main1(String[] args) throws Exception {
        EventLoopGroup clientGrout = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(clientGrout).
        }finally {

        }
    }
}
