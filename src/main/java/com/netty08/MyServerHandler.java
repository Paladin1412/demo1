package com.netty08;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("MyServerHandler  invoke...");
        count++;
        System.out.println("len - " + msg.getLength() + " , content - " + new String(msg.getContent(), Charset.forName("utf-8")));
        byte[] content = msg.getContent();
        Person person = JSON.parseObject(new String(content, Charset.forName("utf-8")), Person.class);
        System.out.println(person.toString());
        System.out.println("count - " + count);
        MessageProtocol protocol = new MessageProtocol();
        String message = "hi client";
        protocol.setLength(message.getBytes().length);
        protocol.setContent(message.getBytes());
        ctx.writeAndFlush(protocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }
}
