/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

/**
 * 优先级间隔尽量大. 优先使用3个常量 1 min,5 norm, 10 max
 * 在1 - 10 之间
 * 
 * @author pengyongshan
 *
 */
public class PriorityTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new TestThread().start(i % 10 + 1);
        }
    }
}

class TestThread implements Runnable {

    public void start(int priority) {
        Thread t = new Thread(this);
        t.setPriority(priority);
        t.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Math.hypot(Math.pow(1987271811, i), Math.cos(i));
        }
        System.out.println("priority:" + Thread.currentThread().getPriority());
    }
}
