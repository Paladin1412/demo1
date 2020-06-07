package com.netty01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

//基于TCP双向通信
public class MyServer {
    public static void main(String[] args) throws Exception {
        //事件循环组，NIO 异步事件循环组，进行selector的时候，注册连接
        /**
         * ThreadFactory创建线程的方法
         *
         * Executor：
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();     //OP_ACCEPT
        EventLoopGroup workerGroup = new NioEventLoopGroup();   //OP_READ

        try{
            /**
             * volatile关键字：
             *
             * 常量存储：
             * ChannelOption存储的是TCP/IP的key的数据
             * AttributeKey存储的是业务数据
             */
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitializer());
            /**
             *  future:封装异步计算的结果，并且提供cancel，isDone等方法
             *      addListener(),观察者模式，当future的异步操作结束以后，会执行operationComplete()操作
             *
             *      sync()等待该future完成
             *  ChannelFuture:完成与未完成两种状态
             *  *                                      +---------------------------+
             *  *                                      | Completed successfully    |
             *  *                                      +---------------------------+
             *  *                                 +---->      isDone() = true      |
             *  * +--------------------------+    |    |   isSuccess() = true      |
             *  * |        Uncompleted       |    |    +===========================+
             *  * +--------------------------+    |    | Completed with failure    |
             *  * |      isDone() = false    |    |    +---------------------------+
             *  * |   isSuccess() = false    |----+---->      isDone() = true      |
             *  * | isCancelled() = false    |    |    |       cause() = non-null  |
             *  * |       cause() = null     |    |    +===========================+
             *  * +--------------------------+    |    | Completed by cancellation |
             *  *                                 |    +---------------------------+
             *  *                                 +---->      isDone() = true      |
             *  *                                      | isCancelled() = true      |
             *  *                                      +---------------------------+
             *      await()不要调用，会造成死锁。
             *          使用addListener()方法
             *
             *   channelFactory：异步调用返回的对象
             *
             *   channel：一个Channel只注册到一个EventLoop
             */
            System.out.println("aaaaaaaaaaa");
            ChannelFuture channelFuture = serverBootstrap.bind(8889).sync();
            System.out.println("aaaaaaaaaaa");
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
