package com.tree.www.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * <p>
 * Created by pysh on 2019-12-02.
 */
public class ByteBufTest {

    public static void main(String[] args) {
        /*----- copy/slice -------*/
        ByteBuf oriBuf = Unpooled.copiedBuffer("netty in action", CharsetUtil.UTF_8);
        ByteBuf copy = oriBuf.copy();
        ByteBuf slice = oriBuf.slice();
        System.out.println("修改前:");
        System.out.println("ori:" + oriBuf.toString(CharsetUtil.UTF_8));
        System.out.println("slice:" + slice.toString(CharsetUtil.UTF_8));
        System.out.println("copy:" + copy.toString(CharsetUtil.UTF_8));
        oriBuf.setByte(0, 'N');
        System.out.println("修改后:");
        System.out.println("ori:" + oriBuf.toString(CharsetUtil.UTF_8));
        System.out.println("slice:" + slice.toString(CharsetUtil.UTF_8));
        System.out.println("copy:" + copy.toString(CharsetUtil.UTF_8));

        /*----- set/get -------*/
        System.out.println((char) oriBuf.getByte(0));
        int readerIndex = oriBuf.readerIndex();
        int writerIndex = oriBuf.writerIndex();
        oriBuf.setByte(0, (byte) 'B');
        System.out.println((char) oriBuf.getByte(0));
        System.out.println(readerIndex == oriBuf.readerIndex());
        System.out.println(writerIndex == oriBuf.writerIndex());

        /*----- read/write -----*/
        oriBuf.readByte();
        oriBuf.writeByte('?');
        System.out.println(oriBuf.toString(CharsetUtil.UTF_8));
        System.out.println(readerIndex == oriBuf.readerIndex());
        System.out.println(writerIndex == oriBuf.readerIndex());
    }
}
