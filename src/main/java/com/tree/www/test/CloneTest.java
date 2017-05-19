/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.test;

/**
 * 克隆效率不比new高。
 * @author pengyongshan
 *
 * @version $Id: CloneTest.java, v 0.1 2017年3月20日 下午5:08:39 pengyongshan Exp $
 */
public class CloneTest {

    public static void main(String[] args) {
        final int times = 1000000;
        Apple apple = new Apple("red");
        long start = System.nanoTime();
        for(int i=0; i < times; i ++) {
            apple.clone();
        }
        long mid = System.nanoTime();
        System.out.println(mid - start);
        for(int i=0; i < times; i ++) {
            new Apple("red");
        }
        long end = System.nanoTime();
        System.out.println(end - mid);
        System.out.println(apple);
    }
}


class Apple implements Cloneable {
    private String color;
    
    public Apple(String color) {
        this.color = color;
    }
    
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
    
    @Override
    public String toString() {
        return "Apple:[color:" + color + "]";
    }
}
