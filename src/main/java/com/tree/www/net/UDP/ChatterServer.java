package com.tree.www.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by pysh on 2017/12/26.
 */
public class ChatterServer {
    static final int INPORT = 1711;

    private byte[] buf  = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private DatagramSocket socket;

    public ChatterServer() {
        try {
            socket = new DatagramSocket(INPORT);
            System.out.println("Server started.");
            while (true) {
                socket.receive(dp);
                String rcvd = Dgram.toString(dp) + ", formAddr:" + dp.getAddress() + ", port:" + dp.getPort();
                System.out.println(rcvd);
                String echoStr = "Echoed:" + rcvd;
                DatagramPacket echo = Dgram.toDatagram(echoStr, dp.getAddress(), dp.getPort());
                socket.send(echo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatterServer();
    }
}
