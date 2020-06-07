package com.netty07;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyServerHandler extends SimpleChannelInboundHandler<Long> {


    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("MyServerHandler  "+msg);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            ctx.channel().writeAndFlush(54321L);
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }
}
