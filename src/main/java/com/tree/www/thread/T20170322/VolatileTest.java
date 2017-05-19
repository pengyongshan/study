/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

/**
 * volatile不能保证数据是同步，只能保证每次取得时候是最新的。同时写的话得不到期望的值。
 * 
 * @author pengyongshan
 *
 * @version $Id: VolatileTest.java, v 0.1 2017年3月22日 上午10:52:09 pengyongshan Exp $
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        int value = 1000;
        int loops = 0;
        ThreadGroup tg = Thread.currentThread().getThreadGroup();

        while (loops++ < 20) {
            UnsafeThread thread = new UnsafeThread();
            for (int i = 0; i < value; i++) {
                new Thread(thread).start();
            }
            
            do {
                Thread.sleep(1000);
            } while (tg.activeCount() != 1);

            if (thread.getCount() != value) {
                System.out.println("循环到第 " + loops + "遍, 出现线程不安全情况");
                System.out.println("此时count=" + thread.getCount());
                break;
            }
        }
    }
}

class UnsafeThread implements Runnable {

    private volatile int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Math.hypot(Math.pow(89182212, i), Math.atan(i));
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
