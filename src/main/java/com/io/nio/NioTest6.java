package com.io.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioTest6 {
    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------------------start--------------------------------------------");
        int[] ports = new int[5];
        ports[0] = 8000;
        ports[1] = 8001;
        ports[2] = 8002;
        ports[3] = 8003;
        ports[4] = 8004;
        Selector selector = Selector.open();

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //配置是否阻塞
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(ports[i]);
            serverSocket.bind(inetSocketAddress);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }

        while (true) {
            //阻塞
            selector.select();
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    //真正所关联的socket对象
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    //真正的注册
                    socketChannel.register(selector, SelectionKey.OP_READ);

                } else if (next.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    int byteRead = 0;
                    StringBuilder builder = new StringBuilder();
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        int read = socketChannel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        builder.append(new String(byteBuffer.array()));
                        byteRead += read;
                    }

                    if (byteRead <= 0) {
                        System.out.println("客户端关闭");
                        next.cancel();
                    }
                    System.out.println(builder.toString());
                }
                iterator.remove();
            }
        }
    }
}
