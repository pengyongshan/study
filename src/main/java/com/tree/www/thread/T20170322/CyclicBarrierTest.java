/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: CyclicBarrierTest.java, v 0.1 2017年3月23日 下午4:06:23 pengyongshan Exp $
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, () -> System.out.println("隧道已经打通。"));

        new Thread(new Worker(cb), "工人1").start();
        new Thread(new Worker(cb), "工人2").start();
    }
}

class Worker implements Runnable {

    private CyclicBarrier cb;

    public Worker(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            int time = new Random().nextInt(10);
            TimeUnit.SECONDS.sleep(time);
            System.out.println(Thread.currentThread().getName() + "-到达汇合点,耗时:" + time + "s");
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
