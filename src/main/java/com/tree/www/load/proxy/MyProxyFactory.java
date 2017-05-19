package com.tree.www.load.proxy;

import java.lang.reflect.Proxy;

public class MyProxyFactory {

	public static Object getProxy(Object target) throws Exception{
		MyInvokationHandler1 handler = new MyInvokationHandler1();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
