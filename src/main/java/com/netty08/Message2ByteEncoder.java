package com.netty08;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class Message2ByteEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("Message2ByteEncoder invoke...");
        System.out.println("len:" + msg.getLength() +
                "  -  content:" + new String(msg.getContent(), Charset.forName("utf-8")));
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
