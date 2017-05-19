/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.factory4Enum;

/**
 * 抽象方法实现
 * @author pengyongshan
 *
 * @version $Id: CarFactory2.java, v 0.1 2017年3月9日 上午11:34:55 pengyongshan Exp $
 */
public enum CarFactory2 {
                         Ford {
                             @Override
                             Car create() {
                                 return new FordCar();
                             }
                         },
                         BenTian {
                             @Override
                             Car create() {
                                 return new BenTianCar();
                             }
                         };

    abstract Car create();
}
