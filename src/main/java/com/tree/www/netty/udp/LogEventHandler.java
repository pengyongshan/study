package com.tree.www.netty.udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Created by pysh on 2019-12-09.
 */
public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent msg) {
        StringBuilder builder = new StringBuilder();
        builder.append(DateFormatUtils.format(msg.getReceived(), "yyyy-MM-dd HH:mm:ss SSS"));
        builder.append("[");
        builder.append(msg.getSource().toString());
        builder.append("][");
        builder.append(msg.getLogfileName());
        builder.append("]:");
        builder.append(msg.getMsg());
        System.out.println(builder.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
