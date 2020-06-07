package com.io.zoroCopy;

import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();
        socket.setReuseAddress(true);
        socket.bind(new InetSocketAddress(9988));

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while (true) {
            try {

                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(true);
                RandomAccessFile fileOutputStream = new RandomAccessFile("D:/study/new02.rar","rw");
                FileChannel fileChannel = fileOutputStream.getChannel();
                int readCount = 0;
                while (true) {
                    byteBuffer.clear();
                    readCount = socketChannel.read(byteBuffer);
                    if(readCount == -1){
                        break;
                    }
                    byteBuffer.rewind();
                }

            } catch (Exception e) {

            }
        }


    }
}
