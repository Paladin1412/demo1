package bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * jdk的byteBuffer 与 netty的byteBuf区别
 * 1.netty采用读写索引分离
 * 2.当读索引与写索引处于同一个位置时，如果继续读取就会抛出（数组越界）异常
 * 3.对于butebuf的任何读写操作都会分别单独维护读索引和写索引
 * <p>
 * jdk的bytebuffer缺点：
 * 1.final byte[] hb;长度固定，不能动态扩容，如果有需要，则创建一个新的byteBuffer，并将数据拷贝过去
 * 2.bytebuffer只使用一个position指针来标志位置信息，需要读写交换时，调用flip、rewind
 * <p>
 * netty的byteBuf优点：
 * 1.存储字节的数组是动态的，其最大值默认是Integer.MAX_VALUE
 * 2.读写索引完全分开
 */


public class Test1 {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(10);
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);

        System.out.println(buffer.maxCapacity() + "   " + buffer.maxWritableBytes());
        for (int i = 0; i < 18; i++) {
            buffer.writeByte(i);
            System.out.println(buffer.toString());
        }
        System.out.println(buffer.toString(Charset.forName("utf-8")));
        for (int i = 0; i < buffer.writerIndex(); i++) {
//            byte b = buffer.readByte();
//            ByteBuf b = buffer.readBytes(i);
            byte b = buffer.getByte(i);     //readIndex不移动
            System.out.println(b + "   " + buffer.toString());
        }

        while (buffer.isReadable()) {
            System.out.println(buffer.readByte());  //自动维护readIndex索引
        }
        System.out.println("readIndex:" + buffer.readerIndex());

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
    }
}
