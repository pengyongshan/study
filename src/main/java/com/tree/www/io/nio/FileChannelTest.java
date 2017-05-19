package com.tree.www.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import com.tree.www.io.Common;

public class FileChannelTest {

	public static void main(String[] args) {
		File file = new File(Common.FILE_NAME);
		FileChannel inChannel = null ;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(file).getChannel();
			outChannel = new FileOutputStream("D:" + File.separator + "pys" + File.separator + "hello1.txt")
					.getChannel();

			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			Charset charset = Charset.forName("UTF-8");
			outChannel.write(buffer);

			buffer.clear();
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.println(charBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
