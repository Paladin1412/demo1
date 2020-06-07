package com.io.nio;

import java.nio.ByteBuffer;

public class NioTest5 {
    public static void main(String[] args) throws Exception {
        //java堆 -> native堆
        //DirectByteBuffer堆上对象，持有的是非java内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        buffer.put((byte) 2);
        System.out.println(buffer);
        System.out.println();
        buffer.flip();
        System.out.println(buffer.get());
    }
}
