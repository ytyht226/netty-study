package com.jd58.netty.ssy.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by yht on 2018/11/16.
 */
public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count = 1;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();
        System.out.println("server received data: ");
        System.out.println("length: " + length);
        System.out.println("content: " + new String(content, Charset.forName("utf-8")));
        System.out.println("count: " + count++);
        System.out.println("----------------------");

        String respMessage = UUID.randomUUID().toString();
        int respLength = respMessage.getBytes(Charset.forName("utf-8")).length;
        byte[] respContent = respMessage.getBytes(Charset.forName("utf-8"));
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(respLength);
        personProtocol.setContent(respContent);
        ctx.writeAndFlush(personProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}