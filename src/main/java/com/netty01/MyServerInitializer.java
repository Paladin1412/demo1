package com.netty01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * ChannelInitializer是一个特殊的入栈处理器
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        /**
         * 处理或拦截信道的入站事件和出站操作的信道处理器列表。
         * 通道管道实现了拦截过滤器模式的高级形式，以便用户完全控制事件的处理方式以及管道中的通道处理器如何相互交互。
         * ChannelPipeline：容器，存放的是一个个的ChannelHandlerContext对象，ctx中存放的是与之对应的ChannelHandler对象
         *                      ChannelHandlerContext是ChannelHandler与ChannelPipeline交互的桥梁
         *  channel管道，处理所有的IO事件，以及与该channel关联的所有事件和请求
         *  里面封装了ChannelHandler的集合
         *
         *  ChannelPipeline里面存储的数据与Context存储的ChannelHandler的关系
         *
         *  ChannelHandler（通道处理器）可以随时添加或删除，因为ChannelPipeline（通道管道）是线程安全的。
         *  例如，您可以在敏感信息即将交换时插入加密处理程序，并在交换后删除它
         *
         *  将多个handler连接起来
         *  按顺序一个一个的处理
         *
         *  AbstractChannel中封装了ChannelPipeline（DefaultChannelPipeline）
         */
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0,4,0,4));
        pipeline.addLast(new LengthFieldPrepender(4));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));

//        ByteToMessageDecoder;


        pipeline.addLast(new MyServerHandler());

    }
}
