package com.tree.www.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.trim().equals("exit")) {
				System.exit(1);
			}
			System.out.println("输入内容是：" + line);
		}
		System.out.println("退出成功");
		br.close();
	}
}
