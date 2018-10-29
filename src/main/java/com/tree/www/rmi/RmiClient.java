package com.tree.www.rmi;

import java.rmi.Naming;

/**
 * Created by pysh on 2018/9/28.
 */
public class RmiClient {

    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:28889/com.tree.www.rmi.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("xxx");
        System.out.println(result);
    }
}
