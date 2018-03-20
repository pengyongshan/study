/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.pattern.decorator.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * 反射实现装饰模式
 *
 * @author pengyongshan
 * @version $Id: Client.java, v 0.1 2017年3月15日 上午11:51:39 pengyongshan Exp $
 */
public class Client {

    public static void main(String[] args) {
        Animal jerry = new Rat();
        jerry = new DecorateAnimal(jerry, FlyFeature.class);
        jerry = new DecorateAnimal(jerry, DigFeature.class);
        jerry.doStuff();
    }
}

interface Animal {
    void doStuff();
}

class Rat implements Animal {

    @Override
    public void doStuff() {
        System.out.println("老鼠打洞");
    }

}

//定义某种能力
interface Feature {
    //加载特性
    void load();
}

class FlyFeature implements Feature {
    @Override
    public void load() {
        System.out.println("加一双翅膀");
    }
}

class DigFeature implements Feature {
    @Override
    public void load() {
        System.out.println("增加打洞能力");
    }
}

class DecorateAnimal implements Animal {

    private Animal animal;

    private Class<? extends Feature> cls;

    public DecorateAnimal(Animal animal, Class<? extends Feature> cls) {
        this.animal = animal;
        this.cls = cls;
    }

    @Override
    public void doStuff() {
        InvocationHandler handler = (proxy, method, args) -> {
            Object obj = null;
            if (Modifier.isPublic(method.getModifiers())) {
                obj = method.invoke(cls.newInstance(), args);
            }
            animal.doStuff();
            return obj;
        };
        ClassLoader cl = getClass().getClassLoader();
        Feature proxy = (Feature) Proxy.newProxyInstance(cl, cls.getInterfaces(), handler);
        proxy.load();
    }
}
