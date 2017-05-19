/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: LockSynchronizedTest.java, v 0.1 2017年3月22日 下午2:59:14 pengyongshan Exp $
 */
public class LockSynchronizedTest {

    public static void runTasks(Class<? extends Runnable> clz) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("*******开始执行" + clz.getName() + " 任务 ******");
        for (int i = 0; i < 4; i++) {
            es.submit(clz.newInstance());
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("---------" + clz.getName() + "任务执行完毕---------\n");
        es.shutdown();
    }

    public static void main(String[] args) throws Exception {
        runTasks(TaskWithLock.class);
        runTasks(TaskWithSync.class);
    }
}

class Task {
    public void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        sb.append("线程名字：" + Thread.currentThread().getName());
        sb.append(",执行时间：" + Calendar.getInstance().get(Calendar.SECOND) + "s");
        System.out.println(sb);
    }
}

// 显示锁任务 
class TaskWithLock extends Task implements Runnable {

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            doSomething();
        } finally {
            lock.unlock();
        }
    }
}

// 内部锁任务
class TaskWithSync extends Task implements Runnable {

    @Override
    public void run() {
        synchronized ("A") {
            doSomething();
        }
    }

}
