/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.factory4Enum;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: Client.java, v 0.1 2017年3月9日 上午11:31:54 pengyongshan Exp $
 */
public class Client {
    public static void main(String[] args) {
        Car car = CarFactory.Ford.create();
        Car car2 = CarFactory2.BenTian.create();
        car.sayHello();
        car2.sayHello();
    }
}
