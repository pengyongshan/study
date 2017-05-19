/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.proxy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 反射实现动态代理
 * 
 * @author pengyongshan
 *
 * @version $Id: Client.java, v 0.1 2017年3月15日 上午11:36:40 pengyongshan Exp $
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new SubjectHandler(subject);
        ClassLoader cl = subject.getClass().getClassLoader();
        Subject proxy = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
        proxy.request();
    }
}
