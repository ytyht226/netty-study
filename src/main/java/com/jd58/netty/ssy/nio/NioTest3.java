package com.jd58.netty.ssy.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yht on 2018/11/17.
 */
public class NioTest3 {

    public static void main(String[] args)  throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] messages = "hello world welcome, nihao".getBytes();

        for (int i = 0; i < messages.length; i++) {
            byteBuffer.put(messages[i]);
        }
        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}