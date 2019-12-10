package com.tree.www.netty.example3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 当 channelRead0()方法完成时，你已经有了传入消息，并且已经处理完它了。当该方 法返回时，
 * SimpleChannelInboundHandler 负责释放指向保存该消息的 ByteBuf 的内存引用。
 *
 * Created by pysh on 2019-11-28.
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    // 从服务器接收到消息时调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        System.out.println("Client received:" + msg.toString(CharsetUtil.UTF_8));
    }

    // 建立连接时调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("netty rocks", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
