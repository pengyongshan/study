package com.tree.www.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * Created by pysh on 2019-11-05.
 */
public class ChannelHandler implements CompletionHandler<Integer, Attachment> {
    @Override
    public void completed(Integer result, Attachment attachment) {
        ByteBuffer buffer = attachment.getBuffer();
        if (attachment.isReadMode()) {
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(buffer.array()).trim();
            System.out.println("收到客户端的请求数据:" + msg);

            buffer.clear();
            buffer.put("Response from server!".getBytes(Charset.forName("UTF-8")));
            attachment.setReadMode(false);
            buffer.flip();

            attachment.getClient().write(buffer, attachment, this);
        } else {
            // 1.等待新的数据
            //attachment.setReadMode(true);
            //attachment.getBuffer().clear();
            //attachment.getClient().read(attachment.getBuffer(), attachment, this);
            // 2.响应完请求，关闭连接
            try {
                attachment.getClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("断开连接！");
    }
}
