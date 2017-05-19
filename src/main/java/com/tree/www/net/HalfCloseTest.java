package com.tree.www.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseTest {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("服务器的第一行数据");
		ps.println("服务器的第二行数据");
		socket.shutdownOutput();
		System.out.println(socket.isClosed());
		Scanner scanner = new Scanner(socket.getInputStream());
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
		socket.close();
		ss.close();
	}
}
