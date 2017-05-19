package com.tree.www.load.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) throws Exception{
		InvocationHandler handler = new MyInvokationHandler();
		Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] { Person.class },
				handler);
		p.walk();
		p.sayHello("jj");
	}
}

interface Person {
	void walk();

	void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler {

	/**
	 * 执行动态代理对象所有方法时，都会被替换成invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("---正在执行的方法:" + method);
		if (args != null) {
			System.out.println("执行该方法时传入的参数为:");
			for (Object object : args) {
				System.out.println(object);
			}
		} else {
			System.out.println("调用该方法没有实参");
		}
		return null;
	}
	
}
