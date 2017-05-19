/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.proxy.reflect;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: RealSubject.java, v 0.1 2017年3月15日 上午11:33:19 pengyongshan Exp $
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("xxxx");
    }
    
}
