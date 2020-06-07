package com.io.zoroCopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 时间：266, 大小：49563999
 * 时间：42, 大小：49563999
 */
public class NewClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",9988));
        socketChannel.configureBlocking(true);

        String file = "D:/study/test.rar";
        FileChannel fileChannel = new FileInputStream(file).getChannel();
        Long startTime = System.currentTimeMillis();

        long size = fileChannel.size();
        long position = 0;
        long total = 0;
        while (position < size) {
            long currentNum = fileChannel.transferTo(position, fileChannel.size(), socketChannel);
//            System.out.println("复制字节数:"+currentNum);
            if (currentNum <= 0) {
                break;
            }
            total += currentNum;
            position += currentNum;
        }

//        long transfer = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println(total);

        System.out.println("时间："+(System.currentTimeMillis() - startTime)+", 大小："+fileChannel.size());

        //时间：100635, 大小：6525547907 new
        //


    }
}
