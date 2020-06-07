package com.io.zoroCopy;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//            FileOutputStream os = new FileOutputStream("D:/study/old01.rar");
            byte[] byteArray = new byte[4096];
            while (true){
                int read = dataInputStream.read(byteArray, 0, byteArray.length);
                if(read == -1){
                    break;
                }
//                os.write(byteArray,0,read);
//                os.flush();
            }
        }
    }
}
