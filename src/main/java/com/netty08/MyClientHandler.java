package com.netty08;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("MyClientHandler  invoke...");
        System.out.println("len - " + msg.getLength() + " , content - " + new String(msg.getContent(), Charset.forName("utf-8")));
        count++;
        System.out.println("count - "+count);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            MessageProtocol messageProtocol = new MessageProtocol();
//            String message = "hello server"+i;
            Person person = new Person();
            person.setName("张三"+i);
            person.setAge(i);
            person.setAddress("hubei"+i);
            messageProtocol.setLength(JSON.toJSONString(person).getBytes().length);
            messageProtocol.setContent(JSON.toJSONString(person).getBytes());

            ctx.writeAndFlush(messageProtocol);
        }
    }
}
