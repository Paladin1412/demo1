package com.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioTest4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("src/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/output.txt");

        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(4);
//        buffer.asReadOnlyBuffer();

        while (true){
            buffer.clear();
            int read = inputStreamChannel.read(buffer);
            if(read == -1){
                break;
            }
            System.out.println(buffer);
            buffer.flip();
            outputStreamChannel.write(buffer);
        }
    }
}
