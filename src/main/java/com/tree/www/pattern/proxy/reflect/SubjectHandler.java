/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.proxy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: SubjectHandler.java, v 0.1 2017年3月15日 上午11:39:21 pengyongshan Exp $
 */
public class SubjectHandler implements InvocationHandler {

    private Subject subject;
    
    public SubjectHandler(Subject subject) {
        this.subject = subject;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("预处理");
        Object obj = method.invoke(subject, args);
        System.out.println("后处理");
        return obj;
    }

}
