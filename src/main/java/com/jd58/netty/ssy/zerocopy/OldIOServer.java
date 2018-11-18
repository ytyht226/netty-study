package com.jd58.netty.ssy.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yanghuitao on 2018/11/18.
 */
public class OldIOServer {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(8899);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] byteArray = new byte[4096];
                while (true) {
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);
                    if (-1 == readCount) {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}