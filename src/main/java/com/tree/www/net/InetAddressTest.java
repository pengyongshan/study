package com.tree.www.net;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("www.crazyit.com");
		System.out.println("crazyit是否可达：" + ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		InetAddress local = InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 });
		System.out.println("本机是否可达:" + local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
				
	}
}
