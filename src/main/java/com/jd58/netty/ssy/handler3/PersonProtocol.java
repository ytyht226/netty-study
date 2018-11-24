package com.jd58.netty.ssy.handler3;

/**
 * Created by yht on 2018/11/24.
 */
public class PersonProtocol {

    private int length;
    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}