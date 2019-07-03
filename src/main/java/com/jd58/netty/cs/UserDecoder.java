package com.jd58.netty.cs;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by yht on 2018/11/24.
 */
public class UserDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {


        User user = new User();
        int msgLength = in.readInt();
        int age = in.readInt();
        byte[] nameBytes = new byte[msgLength - 4];
        in.readBytes(nameBytes);
        String name = new String(nameBytes);

        user.setAge(age);
        user.setName(name);
        out.add(user);
    }
}