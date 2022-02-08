package com.tree.www.io.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        for (int i = 471; i <= 1131; i++) {
            String filePath = "/Users/mac/Documents/yp_data_" + i + ".sql";
            FileInputStream fis = new FileInputStream(filePath);
            FileChannel fc = fis.getChannel();
            ByteBuffer buff = ByteBuffer.allocate(256);
            int count = 0;
            while (fc.read(buff) != -1) {
                buff.flip();
                Charset charset = StandardCharsets.UTF_8;
                CharBuffer charBuffer = charset.decode(buff);
                if (charBuffer.toString().contains(");")) {
                    count++;
                }
                buff.clear();
            }
            if (count > 1) {
                System.out.println(filePath);
            }
        }
    }
}
