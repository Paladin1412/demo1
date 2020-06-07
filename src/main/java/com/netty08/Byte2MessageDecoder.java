package com.netty08;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.util.List;

public class Byte2MessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("Byte2MessageDecoder invoke...");
        int len = in.readInt();
        byte[] bytes = new byte[len];
        ByteBuf byteBuf = in.readBytes(bytes);
        System.out.println("len - "+len);
        System.out.println("bytes - "+new String(bytes,Charset.forName("utf-8")));
//        System.out.println("byteBuf - "+byteBuf.toString(Charset.forName("utf-8")));
        MessageProtocol protocol = new MessageProtocol();
        protocol.setLength(len);
        protocol.setContent(bytes);
        out.add(protocol);

    }

}
