package com.protobuf;

public class ProtobufTest {
    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(18)
                .setAddresss("湖北武汉")
                .build();

        //网络传输字节数组，RPC远程调用传输
        byte[] student2byteArray = student.toByteArray();

        //接受数组进行反序列化
        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2byteArray);
        System.out.println(student2.toString());
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddresss());
    }
}
