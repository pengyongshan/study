package com.tree.www.netty.example1;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by pysh on 2019-11-19.
 */
@ChannelHandler.Sharable
public class HiChannelHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
        channelHandlerContext.writeAndFlush("hello 梦之都：" + s + "\n");
    }
}
