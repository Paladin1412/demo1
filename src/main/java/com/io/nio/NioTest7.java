package com.io.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest7 {
    public static void main(String[] args) throws Exception{
        String in_name = "src/NioTest7_In.txt";
        RandomAccessFile inputFile = new RandomAccessFile("src/NioTest7_In.txt","r");
        RandomAccessFile outputFile = new RandomAccessFile("src/NioTest7_Out.txt","rw");
        long length = new File(in_name).length();
//        System.out.println(length);
//        FileOutputStream outputStream = new FileOutputStream("src/NioTest7_Out.txt");
        FileChannel inputFileChannel = inputFile.getChannel();
        FileChannel outputFileChannel = outputFile.getChannel();

        //将inputChannel中的数据读取到该buffer中，并且自动进行flip操作。
        //java.nio.DirectByteBufferR[pos=0 lim=17 cap=17]
        //0拷贝
        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);
//        System.out.println(inputData);
//        while (inputData.hasRemaining()){
//            System.out.println(inputData.get());
//        }
//        inputData.clear();
//        String message = "hello,你好";
//        ByteBuffer byteBuffer = ByteBuffer.allocate(message.getBytes().length);
//        byteBuffer.put(message.getBytes());
//        byteBuffer.flip();
        Charset charset = Charset.forName("utf-8");
//        CharsetDecoder charsetDecoder = charset.newDecoder();
//        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharBuffer charBuffer = charset.decode(inputData);
        ByteBuffer byteBuffer1 = charset.encode(charBuffer);
        System.out.println(byteBuffer1);
        outputFileChannel.write(byteBuffer1);
        outputFile.close();
        inputFile.close();
    }
}
