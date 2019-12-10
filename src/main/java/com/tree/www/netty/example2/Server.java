package com.tree.www.netty.example2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.net.InetSocketAddress;

/**
 * 粘包拆包
 * Created by pysh on 2019-11-22.
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bs = new ServerBootstrap();
        bs.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .localAddress(new InetSocketAddress(8080))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline p = ch.pipeline();
                        //p.addLast(new LineBasedFrameDecoder(1024)); // 按行分割
                        //p.addLast(new FixedLengthFrameDecoder(100)) // 按固定长度
                        ByteBuf delimiter = Unpooled.copiedBuffer("#_".getBytes()); // 自定义分割符
                        p.addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                        p.addLast(new ServerHandler());
                    }
                });
        try {
            ChannelFuture future = bs.bind().sync();
            if (future.isSuccess()) {
                System.err.println("启动Netty服务成功");
            }
            future.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
