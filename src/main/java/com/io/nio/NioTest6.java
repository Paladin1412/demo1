package com.io.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Handler;

public class NioTest6 {
    public static void main(String[] args) throws Exception {
        int[] ports = new int[5];
        ports[0] = 8000;
        ports[1] = 8001;
        ports[2] = 8002;
        ports[3] = 8003;
        ports[4] = 8004;
        Selector selector = Selector.open();

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);    //配置是否阻塞
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(ports[i]);
            serverSocket.bind(inetSocketAddress);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }
        while (true) {
            int select = selector.select();     //阻塞
            System.out.println("The number of keys: " + select);
            Set<SelectionKey> keySet = selector.selectedKeys();
            System.out.println("This selector's selected-key set: " + keySet);
            Iterator<SelectionKey> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel(); //真正所关联的socket对象
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);  //真正的注册

                    System.out.println("获取到客户端连接： " + socketChannel.getLocalAddress()+" - "+socketChannel.getRemoteAddress());

                } else if (next.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    int byteRead = 0;
                    StringBuilder builder = new StringBuilder();
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        int read = socketChannel.read(byteBuffer);
                        System.out.println("--------"+byteBuffer);
                        if (read <= 0) {
                            System.out.println("read:"+read);
                            break;
                        }
                        byteBuffer.flip();
                        builder.append(new String(byteBuffer.array()));
//                        socketChannel.write(byteBuffer);
                        byteRead += read;
                    }
                    System.out.println("读取：" + byteRead + ",来自：" + socketChannel);
                    System.out.println(builder.toString());
                    if (byteRead <= 0) {
                        System.out.println("客户端关闭");
                        next.cancel();
                    }
                }
                iterator.remove();
            }
        }
    }
}
