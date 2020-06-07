package com.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
//        InputStream stream = new FileInputStream(new File(""));
//        FilterInputStream filterInputStream;
//        Buffer buffer;
//        IntBuffer intBuffer;
//
        //快照的使用，ByteBuffer中的slice()使用的是快照形式，操作的是同一个数组对象
//        SliceTest sliceTest = new SliceTest(new int[10]);
//        System.out.println(sliceTest.hb[0]);
//        sliceTest.put(1);
//        System.out.println(sliceTest.hb[0]);
//        SliceTest slice = sliceTest.slice();
//        slice.put(2);
//        System.out.println(sliceTest.hb[0]);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            if(next==3){
                iterator.remove();
            }
        }
        System.out.println(list.toString());

    }
}
