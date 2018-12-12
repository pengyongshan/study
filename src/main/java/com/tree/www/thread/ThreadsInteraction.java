package com.tree.www.thread;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程间交互
 * <p>
 * Created by pysh on 2018/12/12.
 */
public class ThreadsInteraction {
    public static void main(String[] args) throws Exception {
        //demo1();
        //demo2();
        //demo3();
        //demo4();
        //demo5();
        demo6();
    }

    /**
     * A 和 B 是同时打印1,2,3
     */
    private static void demo1() {
        new Thread(ThreadsInteraction::printNumber, "A").start();
        new Thread(ThreadsInteraction::printNumber, "B").start();
    }

    /**
     * B 在 A 全部打印 完后再开始打印
     */
    private static void demo2() {
        Thread threadA = new Thread(ThreadsInteraction::printNumber, "A");
        new Thread(() -> {
            System.out.println("B 开始等待 A");
            try {
                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNumber();
        }, "B").start();
        threadA.start();
    }

    /**
     * A 在打印完 1 后，再让 B 打印 1, 2, 3，最后再回到 A 继续打印 2, 3
     */
    private static void demo3() {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                printNumber(1);
                System.out.println("A 开始等待...");
                try {
                    lock.wait();
                    printNumber(2);
                    printNumber(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (lock) {
                printNumber(1);
                printNumber(2);
                printNumber(3);
                lock.notify();
            }
        }, "B").start();
    }

    /**
     * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
     * <p>
     * CountdownLatch 适用于一个线程去等待多个线程的情况。
     */
    private static void demo4() {
        int worker = 3;
        CountDownLatch latch = new CountDownLatch(worker);
        new Thread(() -> {
            Stopwatch s = Stopwatch.createStarted();
            System.out.println("D is waiting A,B,C work...");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("all done, waiting " + s.stop().elapsed(TimeUnit.SECONDS) + "s, D start working");

        }, "D").start();

        Random rand = new Random();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tName = String.valueOf(threadName);
            new Thread(() -> {
                int workSecond = rand.nextInt(10);
                try {
                    System.out.println(tName + " start working " + workSecond + "s");
                    TimeUnit.SECONDS.sleep(workSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(tName + " finished");
                latch.countDown();
            }, tName).start();
        }
    }

    /**
     * 有三个跑步运动员，各自准备好后等待其他人，全部准备好后才开始跑
     * <p>
     * CyclicBarrier
     */
    private static void demo5() {
        int runner = 3;
        CyclicBarrier barrier = new CyclicBarrier(runner);
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            Random rand = new Random();
            final String tName = String.valueOf(threadName);
            new Thread(() -> {
                Stopwatch s = Stopwatch.createStarted();
                int prepareSecond = rand.nextInt(9) + 1;
                System.out.println(tName + " is preparing " + prepareSecond + "s");
                try {
                    TimeUnit.SECONDS.sleep(prepareSecond);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("all prepared, waiting " + (s.stop().elapsed(TimeUnit.SECONDS) - prepareSecond) + "s" + tName + " start running ");

            }, tName).start();
        }

    }

    /**
     * 让子线程去计算从 1 加到 100，并把算出的结果返回到主线程
     * <p>
     * Callable & FutureTask
     */
    private static void demo6() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = (() -> {
            System.out.println("task starts");
            Thread.sleep(5000L);
            int result = 0;
            for (int i = 1; i <= 100; i ++) {
                result += i;
            }
            System.out.println("Task finished and return result");
            return result;
        });
        FutureTask task = new FutureTask<>(callable);
        Stopwatch stopwatch = Stopwatch.createStarted();
        new Thread(task).start();
        // task.get() 会等待子线程return
        System.out.println("Result: " + task.get() + ", 耗时: " + stopwatch.stop().elapsed(TimeUnit.SECONDS) + "s");
    }

    private static void printNumber() {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " print:" + i);
        }
    }

    private static void printNumber(int number) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " print:" + number);
    }
}
