package com.jd58.netty.ssy.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * Created by yht on 2018/11/16.
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count = 1;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();
        System.out.println("client received message: ");
        System.out.println("length: " + length);
        System.out.println("content: " + new String(content, Charset.forName("utf-8")));
        System.out.println("count: " + count++);
        System.out.println("----------------------");
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String messageToSend = "sent from client ";
            byte[] content = messageToSend.getBytes(Charset.forName("utf-8"));
            int length = messageToSend.getBytes(Charset.forName("utf-8")).length;

            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setLength(length);
            personProtocol.setContent(content);
            ctx.writeAndFlush(personProtocol);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}