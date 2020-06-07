package com.io.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);   //分配大小为10的缓冲区
        System.out.println(intBuffer);
        for(int i=0;i<intBuffer.capacity()-1;i++){
            int randomNum = new SecureRandom().nextInt(20);
            intBuffer.put(randomNum);
        }
        intBuffer.flip();//buffer状态翻转  buffer由写->读
//        intBuffer.compact();
        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }
}
