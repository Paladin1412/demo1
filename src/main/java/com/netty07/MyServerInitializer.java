package com.netty07;

import com.netty01.LongDecoder;
import com.netty01.LongEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * ChannelInitializer是一个特殊的入栈处理器
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new LongDecoder());
        pipeline.addLast(new LongEncoder());
        pipeline.addLast(new MyServerHandler());

    }
}
