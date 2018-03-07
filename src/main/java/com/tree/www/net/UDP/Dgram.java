package com.tree.www.net.UDP;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Created by pysh on 2017/12/26.
 */
public class Dgram {
    public static DatagramPacket toDatagram(String s, InetAddress address, int destPort) {
        byte[] buf = s.getBytes();
        return new DatagramPacket(buf, buf.length, address, destPort);
    }

    public static String toString(DatagramPacket packet) {
        return new String(packet.getData(), 0, packet.getLength());
    }
}
