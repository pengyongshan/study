/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.concurrent.*;

/**
 * 协调子线程
 *
 * @author pengyongshan
 * @version $Id: CountDownLatchTest.java, v 0.1 2017年3月23日 下午2:40:20 pengyongshan Exp $
 */
public class CountDownLatchTest {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long start = System.currentTimeMillis();
    int num = 10;
    CountDownLatch latch = new CountDownLatch(num);
    ExecutorService es = Executors.newFixedThreadPool(4);
    for (int i = 0; i < num; i++) {
      es.execute(() -> {
        System.out.println("子线程" + Thread.currentThread().getName() + "执行...");
        latch.countDown();
      });
    }
    es.shutdown();
    latch.await(10, TimeUnit.SECONDS);
    long end = System.currentTimeMillis();
    System.out.println("Inquiry耗时： " + (end - start));
  }
}
