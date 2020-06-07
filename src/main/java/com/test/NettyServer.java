package com.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        //handler针对bossGroup
        //childHandler针对workerGroup
        bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new NettyInitializer());

        ChannelFuture channelFuture = bootstrap.bind(9999).sync();
        channelFuture.channel().closeFuture().sync();

        //优雅关闭   如果有链接，会处理完连接在关闭，不在接收新的链接请求
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

    }
}
