package com.io.nio.demo;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress(8000));

        while (true) {
            int select = selector.select();//阻塞，服务器端没有向客户端返回事件动作
            System.out.println(Thread.currentThread().getName()+" - select - "+select);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                try {
                    if (selectionKey.isConnectable()) {
                        System.out.println(Thread.currentThread().getName()+" - selectionKey.isConnectable()");
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if (client.isConnectionPending()) {   //连接是否处于进行状态
                            System.out.println(Thread.currentThread().getName()+" - client.isConnectionPending()");
                            client.finishConnect();

                            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                            writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                            writeBuffer.flip();
                            client.write(writeBuffer);


                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                while (true) {
                                    writeBuffer.clear();
                                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                    String s = bufferedReader.readLine();
                                    writeBuffer.put(s.getBytes());
                                    writeBuffer.flip();
                                    client.write(writeBuffer);
                                }
                            });
                        }
                        client.register(selector,SelectionKey.OP_READ);
                    }else if(selectionKey.isReadable()){
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = client.read(byteBuffer);
                        if(read > 0){
                            String s = new String(byteBuffer.array());
                            System.out.println(Thread.currentThread().getName()+" - "+s);
                        }

                    }
                } catch (Exception e) {
                    selectionKey.cancel();
                    System.out.println("服务器关闭");
                    e.printStackTrace();
                }
                System.out.println("selectionKeys.clear()");
                selectionKeys.clear();
            });


        }

    }
}
