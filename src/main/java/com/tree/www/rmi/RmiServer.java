package com.tree.www.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by pysh on 2018/9/28.
 */
public class RmiServer {

    public static void main(String[] args) throws Exception {
        int port = 28889;
        String url = "rmi://localhost:28889/com.tree.www.rmi.HelloServiceImpl";
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, new HelloServiceImpl());
    }
}
