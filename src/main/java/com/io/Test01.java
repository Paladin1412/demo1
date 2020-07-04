package com.io;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

import java.io.*;
import java.nio.channels.Selector;
import java.util.ArrayList;

public class Test01 {
//    Selector
    public static void main(String[] args) throws Exception{
        InputStream stream = new FileInputStream("");
        stream.read(null);
        InputStreamReader reader = new InputStreamReader(stream);
        int read = reader.read();
        reader.read();

        BufferedReader reader1 = new BufferedReader(reader);
        reader1.close();
        String s = reader1.readLine();


        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(""))));
        bufferedReader.readLine();
        bufferedReader.read();
        BufferedReader ina = new BufferedReader(new InputStreamReader(System.in));






//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(reader);
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
//        bufferedInputStream.read();

    }

    public static void main1(String[] args) {
        int anInt = SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2);
        System.out.println(anInt);

//        ArrayList list = new ArrayList();
//        list.
    }
}
