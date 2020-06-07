package com.io.zoroCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 时间：310, 大小：49563999
 * 时间：364, 大小：49563999
 *
 *
 */
public class OldClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",8899);
        Long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:/study/test.rar");

        OutputStream outputStream = socket.getOutputStream();
        byte[] byteArray = new byte[4096];
        int len = 0;
        Long size = 0L;
        while ((len = fis.read(byteArray,0,byteArray.length)) != -1){
            size+=len;
            outputStream.write(byteArray,0,len);
            outputStream.flush();
        }
        System.out.println("时间："+(System.currentTimeMillis()-startTime)+", 大小："+size);
        fis.close();
        socket.close();


    }
}
