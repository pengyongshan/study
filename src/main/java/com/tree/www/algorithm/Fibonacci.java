package com.tree.www.algorithm;


import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * 斐波那契数列
 * <p>
 * Created by pysh on 2018/7/18.
 */
public class Fibonacci {

    public static void main(String[] args) {

        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println("迭代——结果:" + dieDai(40) + "，耗时:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.reset().start();
        System.out.println("递归——结果:" + diGui(40) + "，耗时:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static int dieDai(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static int diGui(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return diGui(n - 1) + diGui(n - 2);
    }

}
