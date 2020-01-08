/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

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
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(num);

        ExecutorService es = Executors.newFixedThreadPool(num);

        List<Future<Integer>> futures = Lists.newArrayList();

        for (int i = 0; i < num; i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }
        System.out.println(new Date());
        begin.countDown();
        end.await();
        int count = 0;
        for (Future<Integer> future : futures) {
            count += future.get();

            System.out.println(future.get());
        }
        System.out.println("平均分:" + count / num);
        System.out.println(new Date());
    }
}

class Runner implements Callable<Integer> {

    private CountDownLatch begin;

    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int score = new Random().nextInt(10);
        begin.await();
        TimeUnit.SECONDS.sleep(score);
        end.countDown();
        return score;
    }

}
