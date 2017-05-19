package com.tree.www.thread;

public class DeadLockTest implements Runnable{
    private int flag;
    public DeadLockTest(int flag){
        this.flag = flag; 
    }

    static Object o1 = new Object(),o2 = new Object();

    @Override
    public void run() {
        if(flag == 1) {
            synchronized(o1) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 占据o1");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 System.out.println(Thread.currentThread().getName() + " 等待t2释放o2");
                synchronized(o2) {
                    System.out.println("flag == 1");
                }
            }
        }

        if(flag == 2) {
            synchronized(o2) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 占据o2");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 System.out.println(Thread.currentThread().getName() + " 等待t1释放o1");
                synchronized(o1) {
                    System.out.println("flag == 2");
                }
            }
        }

        System.out.println("ok");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockTest(1), "t1");
        Thread t2 = new Thread(new DeadLockTest(2), "t2");
        t1.start();
        t2.start();
    }
}
