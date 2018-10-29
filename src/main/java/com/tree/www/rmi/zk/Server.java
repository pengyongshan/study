package com.tree.www.rmi.zk;

import com.tree.www.rmi.HelloService;
import com.tree.www.rmi.HelloServiceImpl;

import java.util.concurrent.TimeUnit;

/**
 * Created by pysh on 2018/9/28.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("please using command: java server <rmi_hsot>:<rmi_port>");
            System.exit(-1);
        }
        String host = args[0];
        int port = Integer.valueOf(args[1]);
        System.out.println(host + ":" + port + " start...");
        ServiceProvider provider = new ServiceProvider();
        HelloService helloService = new HelloServiceImpl();
        provider.publish(helloService, host, port);
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
