package com.tree.www.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pysh on 2017/12/22.
 */
public class MultiJabberServer {
    static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Started");
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    new ServerOneJabber(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}


class ServerOneJabber extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerOneJabber(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String string = in.readLine();
                if (string.equals("END")) break;
                System.out.println("Echoing:" + string);
                out.println(string);
            }
            System.out.println("closing...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
