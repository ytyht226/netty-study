package com.jd58.netty.ssy.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by yanghuitao on 2018/11/18.
 */
public class OldIOClient {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8899);
        String fileName = "G:\\学习资料\\Nio,Aio,Netty\\Netty\\圣思园 精通并发与netty视频教程（2018最新课)\\49_零拷贝深入剖析及用户空间与内核空间切换方式.mp4";

        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        while((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数: " + total + ", 耗时: " + (System.currentTimeMillis() - startTime));
        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}