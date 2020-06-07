package com.netty06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class MyClientHandler06 extends SimpleChannelInboundHandler<MyData06.MyData> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyData06.MyData msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        DataInfo06.Student student = DataInfo06.Student.newBuilder()
//                .setName("李四")
//                .setAge(11)
//                .setAddresss("湖北荆门")
//                .build();
//        ctx.writeAndFlush(student);

        int i = new Random().nextInt(3);
        MyData06.MyData message = null;
        if(i ==0){
            message = MyData06.MyData.newBuilder()
                    .setDataType(MyData06.MyData.DataType.StudentType)
                    .setStudent(MyData06.Student.newBuilder().
                            setName("王五")
                            .setAge(10)
                            .setAddresss("湖北钟祥")
                            .build())
                    .build();
        }else if(i ==1){
            message = MyData06.MyData.newBuilder()
                    .setDataType(MyData06.MyData.DataType.DogType)
                    .setDog(MyData06.Dog.newBuilder().
                            setName("小狗")
                            .setAge(1)
                            .setAddresss("湖北小狗")
                            .build())
                    .build();
        }else if(i ==2 ){
            message = MyData06.MyData.newBuilder()
                    .setDataType(MyData06.MyData.DataType.CatType)
                    .setCat(MyData06.Cat.newBuilder().
                            setName("小猫")
                            .setAge(2)
                            .setAddresss("湖北小猫")
                            .build())
                    .build();
        }
        ctx.writeAndFlush(message);
    }
}
