package com.tree.www.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * 引导服务器
 * <p>
 * Created by pysh on 2019-12-06.
 */
public class LogEventBroadcaster {
    private final EventLoopGroup group;
    private final Bootstrap bootstrap;
    private final File file;

    public LogEventBroadcaster(File file, InetSocketAddress address) {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new LogEventEncoder(address));
        this.file = file;
    }

    public void run() throws Exception {
        Channel channel = bootstrap.bind(0).sync().channel();
        long pointer = 0;
        for (; ; ) {
            long len = file.length();
            if (len < pointer) {
                // 如果有必要，将文件指针设置 到该文件的最后一个字节
                pointer = len;
            } else if (len > pointer) {
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                // 设置当前文件的文件指针，已确保没有任何旧的日志被发送
                raf.seek(pointer);
                String line;
                while ((line = raf.readLine()) != null) {
                    // 对于每个日志条目，写入一个LogEvent到channel中
                    channel.writeAndFlush(new LogEvent(null, file.getAbsolutePath(), line, -1));
                    TimeUnit.SECONDS.sleep(3);
                }
                pointer = raf.getFilePointer();
                raf.close();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                if(Thread.interrupted()) {
                    break;
                }
            }
        }
    }

    public void stop() {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        LogEventBroadcaster broadcaster =
                new LogEventBroadcaster(new File("/dashu/log/cg-cache-count.log"), new InetSocketAddress("255.255.255.255", 8888));
        try {
            broadcaster.run();
        } finally {
            broadcaster.stop();
        }
    }

}
