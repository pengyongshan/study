package com.tree.www.netty.udp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * Created by pysh on 2019-12-09.
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) {
        ByteBuf buf = msg.content();
        int idx = buf.indexOf(0, buf.readableBytes(), LogEvent.SEPARATOR);
        String fileName = buf.slice(0, idx).toString(CharsetUtil.UTF_8);
        String logMsg = buf.slice(idx + 1, buf.readableBytes()).toString(CharsetUtil.UTF_8);

        LogEvent event = new LogEvent(msg.sender(), fileName, logMsg, System.currentTimeMillis());
        out.add(event);
    }
}
