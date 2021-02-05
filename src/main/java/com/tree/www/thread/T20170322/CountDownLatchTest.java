/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

/**
 * 协调子线程
 * 
 * @author pengyongshan
 *
 * @version $Id: CountDownLatchTest.java, v 0.1 2017年3月23日 下午2:40:20 pengyongshan Exp $
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(()->{
            System.out.println("等待子线程执行...");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("检查执行情况...");
            System.out.println("执行完毕。");
        });
        for (int i = 0; i < num; i++) {
           es.submit(() ->{
               System.out.println("子线程" + Thread.currentThread().getName() + "执行...");
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               latch.countDown();
           });
        }
        es.shutdown();
    }
}
