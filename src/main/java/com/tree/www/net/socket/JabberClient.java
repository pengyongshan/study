package com.tree.www.net.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by pysh on 2017/12/22.
 */
public class JabberClient {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName(null);
        System.out.println("address = " + address);
        try (Socket socket = new Socket(address, JabberServer.PORT)) {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            for (int i = 0; i < 10; i++) {
                out.println("howdy " + i);
                String string = in.readLine();
                System.out.println(string);
            }
             out.println("END");
        } finally {
            System.out.println("closeing");
        }
    }
}
