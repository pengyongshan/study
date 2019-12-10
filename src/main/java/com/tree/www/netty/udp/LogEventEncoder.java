package com.tree.www.netty.udp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * Created by pysh on 2019-12-06.
 */
public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {

    private final InetSocketAddress remoteAddress;

    public LogEventEncoder(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, LogEvent msg, List<Object> out) {
        byte[] fileName = msg.getLogfileName().getBytes(CharsetUtil.UTF_8);
        byte[] logMsg = msg.getMsg().getBytes(CharsetUtil.UTF_8);
        ByteBuf buf = ctx.alloc().buffer(fileName.length + logMsg.length + 1);
        buf.writeBytes(fileName);
        buf.writeByte(LogEvent.SEPARATOR);
        buf.writeBytes(logMsg);
        out.add(new DatagramPacket(buf, remoteAddress));
    }
}
