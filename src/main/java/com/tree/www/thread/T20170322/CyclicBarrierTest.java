/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author pengyongshan
 * @version $Id: CyclicBarrierTest.java, v 0.1 2017年3月23日 下午4:06:23 pengyongshan Exp $
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4, () -> System.out.println("执行完毕"));
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            es.submit(() -> {
                for (int j = 0; j < 2; j++) {
                    try {
                        TimeUnit.SECONDS.sleep(j);
                        System.out.println("子线程" + Thread.currentThread().getName() + "执行...");
                        cb.await(); // count--, count=0时，唤醒其它线程同时开启下一轮。
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
