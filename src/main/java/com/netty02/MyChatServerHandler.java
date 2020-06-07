package com.netty02;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    //保存所有的channel,连接断开后，会自动的从channelGroup中移除该channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if(channel != ch){
                String sendMsg = channel.remoteAddress()+"发送的消息:"+msg+"\n";
                ch.writeAndFlush(sendMsg);
            }else {
                ch.writeAndFlush("【自己】:"+msg+"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】-"+channel.remoteAddress()+"加入\n");
        channelGroup.add(channel);
    }

    //当强制性（非正常退出时），该方法不会被调用
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //连接断开后，会自动的从channelGroup中移除该channel
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】-"+channel.remoteAddress()+"移除\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"上线了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"下线了");
    }
}
