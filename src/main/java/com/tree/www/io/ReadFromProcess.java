package com.tree.www.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 读取其它进程的输出信息
public class ReadFromProcess {

	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("java");
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String buff = null;
		while ((buff = br.readLine()) != null) {
			System.out.println(buff);
		}
		br.close();
	}
}
