package com.tree.www.netty.example1;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pysh on 2019-11-21.
 */
@ChannelHandler.Sharable
public class HiChannelHandler2 extends SimpleChannelInboundHandler<String> {

    private Map<String, String> userMap = new ConcurrentHashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        String id = ctx.channel().id().asShortText();
        if (msg.startsWith("name")) {
            String name = "匿名";
            if (msg.length() > 4) {
                name = msg.substring(4);
            }
            userMap.put(id,name);
            ctx.writeAndFlush("用户名被设置为:" + name + "\n");
            return;
        }
        ctx.writeAndFlush(userMap.get(id) + ":" + msg + "\n");
    }
}
