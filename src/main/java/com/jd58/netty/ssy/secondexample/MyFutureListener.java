package com.jd58.netty.ssy.secondexample;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Created by yanghuitao on 2018/11/22.
 */
public class MyFutureListener implements GenericFutureListener {
    @Override
    public void operationComplete(Future future) throws Exception {
        System.out.println("task: " + future.isSuccess());
    }
}