package bytebuf;

import com.google.gson.internal.$Gson$Preconditions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Iterator;

public class Test3 {
    public static void main(String[] args) {
        /**
         * netty Bytebuf提供的3中缓冲区类型
         *  heap buffer:堆缓冲区
         *      最常用的类型，byteBuf将数据存储到JVM的堆，并且将实际的数据存放到ByteArray中
         *      优点：由于数据是存储在jvm的堆中，因此可以快速的创建和释放，提供了直接访问内部字节数组的方法
         *      缺点：每次读写数据时，都需要将数据复制到直接缓冲区在进行网络传输
         *  direct buffer：直接缓冲区
         *      在堆外直接分配内存空间，直接缓冲区不会占用堆的容量空间，是由OS在本地内存进行的数据分配
         *      优点：在使用socket运行数据传递时性能好，因为数据直接位于OS本地内存中，不需要从jvm将数据复制到直接缓冲区中，性能好
         *      缺点：因为direct buffer是直接在OS内存中的，内存空间的分配与释放比堆空间更加复杂，速度慢
         *      netty通过提供内存池来解决这个问题
         *      直接缓冲区不支持通过字节数组的方式访问数据。
         *
         *  对于后端业务消息的编解码推荐使用heap bytebuf
         *  对于I/O通信线程在读写缓冲区时推荐direct bytebuf
         *
         *  composite buffer(复合缓冲区)
         *
         */
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        ByteBuf heapBuf = Unpooled.buffer();
        ByteBuf directBuffer = Unpooled.directBuffer();

        compositeByteBuf.addComponents(heapBuf,directBuffer);
//        compositeByteBuf.removeComponent(0);
        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        compositeByteBuf.forEach(System.out::println);

    }
}
