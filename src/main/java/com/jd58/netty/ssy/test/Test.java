package com.jd58.netty.ssy.test;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * Created by yht on 2018/11/18.
 */
public class Test {

    public static void main(String[] args) {
        int result = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

        System.out.println(result);
    }
}