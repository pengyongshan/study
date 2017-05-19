package com.tree.www.io.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import com.tree.www.io.Common;

public class ReadFile {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(Common.FILE_NAME);
		FileChannel fc = fis.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(256);
		while (fc.read(buff) != -1) {
			buff.flip();
			Charset charset = Charset.forName("UTF-8");
			// CharsetDecoder decoder = charset.newDecoder();
			// CharBuffer charBuffer = decoder.decode(buff);
			CharBuffer charBuffer = charset.decode(buff);
			System.out.println(charBuffer);
			buff.clear();
		}
	}
}
