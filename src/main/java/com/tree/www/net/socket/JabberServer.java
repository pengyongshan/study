package com.tree.www.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pysh on 2017/12/22.
 */
public class JabberServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("started:" + serverSocket);

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Connection accepted:" + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                while (true) {
                    String string = in.readLine();
                    if (string.equals("END")) break;
                    System.out.println("receive:" + string);
                    out.println("back:" + string);
                }
            } finally {
                System.out.println("closing...");
            }
        }
    }
}
