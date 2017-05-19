/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.thread.T20170322;

import java.util.concurrent.TimeUnit;

/**
 * 使用线程异常处理器提升系统稳定性
 * 
 * @author pengyongshan
 *
 * @version $Id: ExceptionHandlerTest.java, v 0.1 2017年3月22日 上午10:42:28 pengyongshan Exp $
 */
public class ExceptionHandlerTest {

    public static void main(String[] args) {
        new TcpServer();
    }
}

class TcpServer implements Runnable {

    public TcpServer() {
        Thread thread = new Thread(this);
        thread.setUncaughtExceptionHandler(new TcpServerExceptionHandler());
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("系统正常运行:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException();
    }

    private static class TcpServerExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(" 线程 " + t.getName() + "出现异常,自动重启。");
            e.printStackTrace();
            new TcpServer();
        }

    }
}


