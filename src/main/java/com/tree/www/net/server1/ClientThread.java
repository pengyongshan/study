package com.tree.www.net.server1;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
	BufferedReader br = null;

	public ClientThread(BufferedReader br) {
		this.br = br;
	}

	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
