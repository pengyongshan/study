/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.factory4Enum;

/**
 * 非静态方法
 * @author pengyongshan
 *
 * @version $Id: CarFactory.java, v 0.1 2017年3月9日 上午11:29:02 pengyongshan Exp $
 */
public enum CarFactory {
                        Ford, BenTian;

    public Car create(){
        switch (this) {
            case Ford:
                return new FordCar();
            case BenTian:
                return new BenTianCar();
            default:
                System.out.println("无效的参数");
                return null;
        }
    }
}
