package com.tree.www.netty.udp;

import java.net.InetSocketAddress;

/**
 * 消息POJO
 * <p>
 * Created by pysh on 2019-12-06.
 */
public class LogEvent {
    public static final byte SEPARATOR = (byte) ':';
    private final InetSocketAddress source;
    private final String logfileName;
    private final String msg;
    private final long received;

    public LogEvent(String logfileName, String msg) {
        this(null, logfileName, msg, -1);
    }

    public LogEvent(InetSocketAddress source, String logfileName, String msg, long received) {
        this.source = source;
        this.logfileName = logfileName;
        this.msg = msg;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfileName() {
        return logfileName;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }

}
