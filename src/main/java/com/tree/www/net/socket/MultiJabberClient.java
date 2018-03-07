package com.tree.www.net.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by pysh on 2017/12/22.
 */
public class MultiJabberClient {
    static final int MAX_THREADS = 4;

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName(null);
        while(true) {
            if(JabberClientThread.threadCount() < MAX_THREADS) {
                new JabberClientThread(address);
                TimeUnit.MILLISECONDS.sleep(100L);
            }
        }
    }
}

class JabberClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public static int counter = 0;
    private int id = counter ++;
    private static int threadCount = 0;
    public static int threadCount() {
        return threadCount;
    }

    public JabberClientThread(InetAddress address) {
        System.out.println("making client " + id);
        threadCount ++;
        try {
            socket = new Socket(address, MultiJabberServer.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            start();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            for(int i =0; i<25; i++) {
                out.println("client " + id + ":" + i);
                String string = in.readLine();
                System.out.println(string);
            }
            out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            threadCount --;
        }
    }
}
