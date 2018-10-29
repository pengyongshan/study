package com.tree.www.rmi.zk;

import com.tree.www.rmi.HelloService;

/**
 * Created by pysh on 2018/9/28.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        ServiceConsumer consumer = new ServiceConsumer();
        while (true) {
            HelloService helloService = consumer.lookUp();
            String result = helloService.sayHello("pysh");
            System.out.println(result);
            Thread.sleep(3000);
        }
    }
}
