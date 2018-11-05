package com.jd58.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yanghuitao on 2018/11/5.
 */
public class BufferDemo {
    public static void main(String[] args){
        try {
            RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(48);

            int bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.print((char) buffer.get());
                }
                System.out.println();
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}