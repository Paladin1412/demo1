package bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class Test2 {
    public static void main(String[] args) {
        //Unpooled  未池化的，用完就消除掉
        //utf8/16，中文占3个字节       utf32，中文占4个字节
        ByteBuf byteBuf = Unpooled.copiedBuffer("张hello world", Charset.forName("utf-8"));
        System.out.println(byteBuf.getCharSequence(0,4,Charset.forName("utf-8")));

        System.out.println(byteBuf.toString());
        System.out.println(byteBuf.toString(Charset.forName("utf-8")));

        if (byteBuf.hasArray()) {//true:堆上缓冲
            byte[] array = byteBuf.array();
            System.out.println(new String(array, Charset.forName("utf-8")));

        }
        System.out.println(byteBuf.arrayOffset());
        System.out.println(byteBuf.readerIndex());
        System.out.println(byteBuf.writerIndex());

        System.out.println(byteBuf.readableBytes());   // == (writerIndex-readerIndex)
        System.out.println((char) byteBuf.getByte(0));
        System.out.println((char) byteBuf.getByte(1));
        System.out.println((char) byteBuf.getByte(2));
        System.out.println((char) byteBuf.getByte(3));


    }
}
