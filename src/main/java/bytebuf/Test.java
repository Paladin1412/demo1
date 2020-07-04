package bytebuf;

import dx.zhenxing.Allocate;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        Selector selector = Selector.open();
        SelectorProvider provider = selector.provider();
        AbstractSelector abstractSelector = provider.openSelector();

        for (int i = 5001; i < 5003; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(i));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }
        while (true) {
            int select = selector.select();
            System.out.println(select);
            Set<SelectionKey> keys = selector.keys();
            keys.stream().forEach(System.out::println);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.stream().forEach(System.out::println);

            selector.close();

            Thread.sleep(1000);
        }

    }

    //Scattering与Gathering，将channel的数据写入buffer数组中，或者从buffer数组中读取数据
    public static void main3(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(1234);
        serverSocketChannel.bind(socketAddress);
        SocketChannel socketChannel = serverSocketChannel.accept();

        int size = 4 + 6;
        ByteBuffer[] buffers = new ByteBuffer[2];
        buffers[0] = ByteBuffer.allocate(4);
        buffers[1] = ByteBuffer.allocate(6);
        while (true) {
            int readSize = 0;
            while (readSize < size) {
                long read = socketChannel.read(buffers);
                readSize += read;
            }
            System.out.println("readSize: " + readSize);
            Arrays.asList(buffers).forEach(buffer -> buffer.flip());
            socketChannel.write(buffers);
            Arrays.asList(buffers).forEach(byteBuffer -> byteBuffer.clear());
        }
    }


    public static void main2(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("a.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
//        map.put("hello".getBytes());
        while (map.hasRemaining()) {
            byte b = map.get();
            System.out.println((char) b);
        }
        map.clear();
//        map
        FileLock lock = channel.lock();
        lock.release();


    }


    public static void main1(String[] args) throws IOException {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int a = max + 1;
        System.out.println(max + " " + (a == min) + " " + min);
        System.out.println(1 > (max + 1));
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        ByteBuffer slice = byteBuffer.slice();
        ByteBuffer byteBuffer1 = slice.asReadOnlyBuffer();
        ByteBuffer direct = ByteBuffer.allocateDirect(10);
        direct.flip();
        direct.clear();

//        direct.put();


    }
}
