/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 
 * @author pengyongshan
 *
 * @version $Id: ExecutorServiceTest.java, v 0.1 2017年3月22日 上午11:32:01 pengyongshan Exp $
 */
public class ExecutorServiceTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        ExecutorService es2 = Executors.newCachedThreadPool();
        ExecutorService es3 = Executors.newSingleThreadExecutor();
        test(es);
        Thread.sleep(1000);
        System.out.println();
        test(es2);
        Thread.sleep(1000);
        System.out.println();
        test(es3);
    }

    static void test(ExecutorService es) {
        for (int i = 0; i < 10; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
