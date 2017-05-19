/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 定时
 * @author pengyongshan
 *
 * @version $Id: ScheduledExecutorTest.java, v 0.1 2017年3月22日 下午2:18:00 pengyongshan Exp $
 */
public class ScheduledExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(4);
        /***
         * 是以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕，
         * 如果上一个任务执行完毕，则当前任务立即执行，如果上一个任务没有执行完毕，
         * 则需要等上一个任务执行完毕后立即执行
         * 间隔时间: max(任务执行时间, period)。
         */
        es.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    System.out.println("atFixed..." + DateFormatUtils.format(new Date(), "ss"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 2, TimeUnit.SECONDS);

        /**
         *  是以上一个任务结束时开始计时，period时间过去后，立刻执行。
         *  间隔时间:任务执行时间  + period
         */
        es.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    System.out.println("withFixed..." + DateFormatUtils.format(new Date(), "ss"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
