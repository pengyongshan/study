package com.tree.www.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        //new Producter(bq).start();
        //new Producter(bq).start();
        new Producter(bq).start();
        new Consumer1(bq).start();
    }
}

class Producter extends Thread {
    private BlockingQueue<String> bq;

    public Producter(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        String[] arr = {"java", "C", "C++"};
        for (int i = 0; i < 99999999; i++) {
            try {
                Thread.sleep(200);
                String str = arr[i % 3];
                System.out.println(getName() + "生产者生产：" + str);
                bq.put(arr[i % 3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成");
        }
    }
}

class Consumer1 extends Thread {
    private BlockingQueue<String> bq;

    public Consumer1(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
                System.out.println(getName() + "消费者消费:" + bq.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
