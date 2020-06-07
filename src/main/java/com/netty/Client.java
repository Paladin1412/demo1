package com.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class Client {
    public static void main(String[] args) throws Exception {
        EventLoopGroup clientGrout = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(clientGrout).
        }finally {

        }
    }
}
