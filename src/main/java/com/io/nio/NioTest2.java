package com.io.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("src/NioText2.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);
        byteBuffer.flip();
//        byteBuffer.compact();
//        compact()
//        while (byteBuffer.hasRemaining())
        while (byteBuffer.remaining() > 0) {
            System.out.println("1 - " + byteBuffer);
            byte b = byteBuffer.get();
            System.out.println((char) b);
            System.out.println("2 - " + byteBuffer);
        }
        //compact()
        //将所有未读的数据复制到buffer的起始位置处
        //将position设置为最后一个未读的元素的后面
        //将limit设置为capacity
        byteBuffer.compact();
        System.out.println("3 - " + byteBuffer);
        System.out.println("capacity4:" + byteBuffer.capacity() + "  limit:" + byteBuffer.limit() + "   position:" + byteBuffer.position());
    }
}
