/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步
 * @author pengyongshan
 *
 * @version $Id: CallableTest.java, v 0.1 2017年3月16日 上午9:51:45 pengyongshan Exp $
 */
public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(new TaxCalculator(140));
        while (!future.isDone()) {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print("#");
        }
        System.out.println("\n计算完成，税金为 " + future.get() + "元");
        es.shutdown();
    }
}

class TaxCalculator implements Callable<Integer> {

    private int seedMoney;
    
    public TaxCalculator(int seedMoney) {
        this.seedMoney = seedMoney;
    }
    
    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(2000);
        return seedMoney / 10;
    }
    
}
