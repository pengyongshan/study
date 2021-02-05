package com.tree.www.thread;

/**
 * 交替打印
 * <p>
 * Created by pysh on 2020/12/24.
 */
public class ThreadABAB {
    private static int i = 1;
    private static final byte[] BLOCK = new byte[0];

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            synchronized (BLOCK) {
                while (i <= 100) {
                    if (i % 2 == 1) {
                        System.out.println("ThreadA:" + i++);
                        BLOCK.notify();
                    } else {
                        try {
                            BLOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread B = new Thread(() -> {
            synchronized (BLOCK) {
                while (i <= 100) {
                    if (i % 2 == 0) {
                        System.out.println("ThreadB:" + i++);
                        BLOCK.notify();
                    } else {
                        try {
                            BLOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        B.start();
        A.start();
    }
}
