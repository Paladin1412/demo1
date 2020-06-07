package com.netty01;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * netty处理器分为两类：入栈、出栈
 *
 * 入栈处理器的顶层：ChannelInboundHandler
 * 出栈处理器的顶层：ChannelOutboundHandler
 *
 * 数据处理时常用的各种编解码器本质上都是处理器
 * 编解码器：编码器、解码器。    网络中传输的数据均是字节流。
 *      编解码统一称为：codec
 *      编码(Encode)：数据->字节   本质上是出栈处理器
 *
 *      解码(Decode)：字节->数据
 *
 *
 *
 *
 */

public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    /**
     * ChannelHandlerContext是ChannelHandler与ChannelPipeline交互的桥梁
     *
     * ChannelHandlerContext与ChannelHandler之间的关联绑定关系是永远不会发生改变的，因此可以对其进行缓存
     * 对于Channel的同名方法来说ChannelHandlerContext的方法会产生更短的事件流，因此可以在可能的情况下充分应用此特性来提升性能
     */

    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+", "+msg);
//        System.out.println(ctx.channel() instanceof ChannelInboundHandler);
//        System.out.println(ctx.channel() instanceof ChannelOutboundHandler);

        //直接往外写，消息会从channel的最后一个handler开始逐渐经过每一个出站的消息抵达目标
//        ctx.channel().writeAndFlush("from server: "+ UUID.randomUUID());
//        //从当前的handler的下一个handler开始往外传输
//        ctx.writeAndFlush("123");

        //业务逻辑中有耗时操作的时候，使用线程池进行处理，因为此处的执行是处于I/O线程中，会阻塞线程
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            ctx.channel().writeAndFlush("from server "+Thread.currentThread().getName()+": "+ UUID.randomUUID());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ctx.writeAndFlush(Thread.currentThread().getName());
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        Bootstrap bootstrap = new Bootstrap();
//        bootstrap.group(ctx.channel().eventLoop())  //直接沿用当前这台机器作为server的EventLoop作为第二台server的groupLoop
//                .channel(NioSocketChannel.class)
//                .handler(new MyClientInitializer());
//
//        ChannelFuture channelFuture = bootstrap.connect("localhost",8889).sync();
//        channelFuture.channel().closeFuture().sync();
    }
}
