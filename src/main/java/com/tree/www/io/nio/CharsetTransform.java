package com.tree.www.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class CharsetTransform {

	public static void main(String[] args) throws Exception {
		Charset cn = StandardCharsets.UTF_8;
		CharsetEncoder en = cn.newEncoder();
		CharsetDecoder de = cn.newDecoder();
		CharBuffer cbuff = CharBuffer.allocate(10);
		cbuff.put('死');
		cbuff.put('鬼');
		cbuff.flip();
		ByteBuffer bbuff = en.encode(cbuff);
		for (int i = 0; i < bbuff.limit(); i++) {
			System.out.print(bbuff.get(i) + " ");
		}
		
		System.out.println("\n" + de.decode(bbuff));
	}
}
