package com.jd58.netty.ssy.nio;

import java.nio.ByteBuffer;

/**
 * readonly buffer
 * Created by yanghuitao on 2018/11/17.
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());

        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.print(buffer.get(i) + " ");
        }
        buffer.position(0);
        buffer.put(0, (byte)1);
        System.out.println();
        for (int i = 0; i < readonlyBuffer.capacity(); i++) {
            System.out.print(readonlyBuffer.get(i) + " ");
        }

    }
}