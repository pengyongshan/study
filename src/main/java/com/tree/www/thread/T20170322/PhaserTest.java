package com.tree.www.thread.T20170322;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * A reusable synchronization barrier, similar in functionality to
 * {@link java.util.concurrent.CyclicBarrier CyclicBarrier} and
 * {@link java.util.concurrent.CountDownLatch CountDownLatch}
 * but supporting more flexible usage.
 * <p>
 * Created by pysh on 2019-09-26.
 */
public class PhaserTest {

    public static void main(String[] args) {
        base(); // 栅栏基本功能
        //tiesTest(); // 树状结构
        //subSection(); // 分段
    }

    private static void subSection() {
        int parties = 3, phases = 4;
        final Phaser phaser = new Phaser(parties) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("======Phase:" + phase + ", registeredParties:" + registeredParties + "=======");
                return super.onAdvance(phase, registeredParties);
            }
        };
        for (int i = 0; i < parties; i++) {
            int threadId = i;
            Thread thread = new Thread(() -> {
                for (int phase = 0; phase < phases; phase++) {
                    System.out.println(String.format("Thread %s, phase %s", threadId, phase));
                    phaser.arriveAndAwaitAdvance();
                }
            });
            thread.start();
        }
    }

    private static void tiesTest() {
        Phaser root = new Phaser(5);
        Phaser n1 = new Phaser(root, 5);
        Phaser n2 = new Phaser(root, 5);
        Phaser m1 = new Phaser(n1, 5);
        Phaser m2 = new Phaser(n1, 5);
        Phaser m3 = new Phaser(n1, 5);
        Phaser m4 = new Phaser(n2, 5);
        Phaser m5 = new Phaser(n2);
        System.out.println("n2 parties:" + n2.getRegisteredParties());
        m5.register();
        System.out.println("n2 parties:" + n2.getRegisteredParties());
        m5.arriveAndDeregister();
        System.out.println("n2 parties:" + n2.getRegisteredParties());
    }

    public static void base() {
        Phaser phaser = new Phaser();
        phaser.register();

        for (int i = 0; i < 10; i++) {
            phaser.register();
            int finalI = i;
            Executors.newFixedThreadPool(4).submit(() -> {
                try {
                    Thread.sleep(finalI * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName());
            });
        }
        phaser.arriveAndDeregister();
    }
}
