package com.tree.www.io.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import com.tree.www.io.Common;

public class FileLockTest {

	private static void main(String[] args) throws Exception {
		FileChannel channel = new FileOutputStream(Common.FILE_NAME, true).getChannel();
		FileLock lock = channel.tryLock();
		if (lock != null) {
			Thread.currentThread().sleep(10000);
			lock.release();
			System.out.println("ok");
		}
	}

}
