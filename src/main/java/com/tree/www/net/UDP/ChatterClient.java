package com.tree.www.net.UDP;

import java.net.*;

/**
 * Created by pysh on 2017/12/26.
 */
public class ChatterClient extends Thread {
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buf = new byte[1000];
    private DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
    private int id;

    public ChatterClient(int identifier) {
        id = identifier;
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName(null);
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("ChatterClient starting...");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ChatterClient(i).start();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 25; i ++) {
                String outMsg = "Client #" + id + ", msg #" + i;
                socket.send(Dgram.toDatagram(outMsg, address, ChatterServer.INPORT));
                socket.receive(datagramPacket);
                String rcvd = "Client #" + id +
                        ", rcvd from " + datagramPacket.getAddress() + ":" + datagramPacket.getPort()
                        + ", msg:" + Dgram.toString(datagramPacket);
                System.out.println(rcvd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
