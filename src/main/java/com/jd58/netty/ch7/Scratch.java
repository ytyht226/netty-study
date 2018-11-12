package com.jd58.netty.ch7;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * Created by yanghuitao on 2018/11/11.
 */
public class Scratch {
    public static void main(String[] args) {
        int page = 1024 * 8;
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
//        allocator.directBuffer(2 * page);
        ByteBuf byteBuf = allocator.directBuffer(16);
        byteBuf.release();
    }
}