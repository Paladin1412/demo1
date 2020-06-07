package com.io.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static sun.security.krb5.Confounder.bytes;

public class NioTest3 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("src/NioText3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        String message = "hello,world你好";

//        byte[] bytes = "hello,world".getBytes();

        Charset charset = Charset.forName("utf-8");
        ByteBuffer byteBuffer = charset.encode(message);

        System.out.println(byteBuffer);
//        for (int i=0;i<bytes.length;i++){
//            byteBuffer.put(bytes(i));
//        }


//        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }
}
