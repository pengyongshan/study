package com.tree.www.io.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.tree.www.io.Common;

public class RandomFileChannelTest {
	public static void main(String[] args) throws Exception {
		File file = new File(Common.FILE_NAME);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		FileChannel randChannel = raf.getChannel();
		ByteBuffer buffer = randChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

		randChannel.position(file.length());
		randChannel.write(buffer);
		randChannel.close();
		raf.close();
	}
}
