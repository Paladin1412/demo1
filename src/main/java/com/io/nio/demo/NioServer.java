package com.io.nio.demo;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.BiConsumer;

public class NioServer {
    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();   //获取服务端的channel
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();   // 获取服务端的socket

        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
        serverSocket.bind(inetSocketAddress);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);     //将ServerSocketChannel注册到selector 事件

        //开始进行服务器的监听
        while (true) {
            selector.select();  //一直阻塞，一直到SelectionKey.OP_ACCEPT监听的事件   返回所关注的事件的数量
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                SocketChannel client;
                try {
                    if (selectionKey.isAcceptable()) {    //如果此时是发起连接事件
                        System.out.println(Thread.currentThread().getName() + " selectionKey.isAcceptable()");
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                        String key = UUID.randomUUID().toString();
                        clientMap.put(key, client);

                    } else if (selectionKey.isReadable()) {
                        System.out.println(Thread.currentThread().getName() + " selectionKey.isReadable()");
                        String receiveMSG = null;
                        client = (SocketChannel) selectionKey.channel();

                        ByteBuffer readBuffer = ByteBuffer.allocate(512);
                        int read = 0;
                        boolean flag = true;
//                        try {
                            read = client.read(readBuffer);
//                            flag = false;
//                        } catch (Exception e) {
//                        }

                        System.out.println("read-->" + read);
                        if (read > 0) {
                            readBuffer.flip();
                            Charset charset = Charset.forName("utf-8");
                            receiveMSG = String.valueOf(charset.decode(readBuffer).array());
                            System.out.println(Thread.currentThread().getName() + " - " + client + ":" + receiveMSG);
                        }
//                        } else if (read <= 0 && flag) {
//                            System.out.println("2222222222客户端关闭");
//                            selectionKey.cancel();
//
//                        }
                        String key = null;
                        for (Map.Entry<String, SocketChannel> map : clientMap.entrySet()) {
                            if (map.getValue() == client) {
                                key = map.getKey();
                                break;
                            }
                        }
                        for (Map.Entry<String, SocketChannel> map : clientMap.entrySet()) {
                            SocketChannel channel = map.getValue();
                            ByteBuffer buffer = ByteBuffer.allocate(512);
                            String msg = key + ":" + receiveMSG;
                            System.out.println("msg - " + msg);
                            buffer.put(msg.getBytes());
                            buffer.flip();
                            channel.write(buffer);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("1111111111");
                    selectionKey.cancel();
                    e.printStackTrace();
                    System.out.println("客户端关闭");
                }


            });
            System.out.println("selectionKeys.clear()");
            selectionKeys.clear();
        }


    }
}
