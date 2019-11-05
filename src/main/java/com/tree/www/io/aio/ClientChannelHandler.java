package com.tree.www.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * Created by pysh on 2019-11-05.
 */
public class ClientChannelHandler implements CompletionHandler<Integer, Attachment> {
    @Override
    public void completed(Integer result, Attachment attachment) {
        ByteBuffer buffer = attachment.getBuffer();
        if (attachment.isReadMode()) {
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(bytes, Charset.forName("UTF-8"));
            System.out.println("收到响应:" + msg);

             //接下来，有以下两种选择:
             //1. 向服务端发送新的数据
            //attachment.setReadMode(false);
            //buffer.clear();
            //String newMsg = "new message from client";
            //byte[] data = newMsg.getBytes(Charset.forName("UTF-8"));
            //buffer.put(data);
            //buffer.flip();
            //attachment.getClient().write(buffer, attachment, this);
            // 2. 关闭连接
            try {
                attachment.getClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            attachment.setReadMode(true);
            buffer.clear();
            attachment.getClient().read(buffer, attachment, this);
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("服务器无响应");
    }
}
