package com.jd58.netty.ssy.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yanghuitao on 2018/11/18.
 */
public class NewIOClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "G:\\学习资料\\Nio,Aio,Netty\\Netty\\圣思园 精通并发与netty视频教程（2018最新课)\\49_零拷贝深入剖析及用户空间与内核空间切换方式.mp4";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送总字节数: " + transferCount + ", 耗时: " + (System.currentTimeMillis() - startTime));
        fileChannel.close();
    }
}