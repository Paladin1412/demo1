package com.netty06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyServerHandler06 extends SimpleChannelInboundHandler<MyData06.MyData> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyData06.MyData msg) throws Exception {
        System.out.println(msg);
        MyData06.MyData.DataType dataType = msg.getDataType();
        switch (dataType){
            case StudentType:
                MyData06.Student student = msg.getStudent();
                System.out.println("student:\n"+student);
                break;
            case CatType:
                MyData06.Cat cat = msg.getCat();
                System.out.println("cat:\n"+cat);
                break;
            case DogType:
                MyData06.Dog dog = msg.getDog();
                System.out.println("dog:\n"+dog);
                break;
        }
    }
}
