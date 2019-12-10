package com.tree.www.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pysh on 2018/9/29.
 */
public class TimeServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("TimeServer started on 8080...");
            while (true) {
                Socket client = server.accept();
                new Thread(new TimeServerHandler(client)).start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert server != null;
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
