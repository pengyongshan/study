package com.tree.www.java8;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by pysh on 2018/6/7.
 */
public class StreamDemo {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream stream = random.ints(1, 10000).limit(1000000).parallel();

        Stopwatch stopwatch = Stopwatch.createStarted();
        //long start = System.currentTimeMillis();
        stream.forEach(i -> i++);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        //System.out.println(System.currentTimeMillis() - start);

        stream = random.ints(1, 10000).limit(1000000);
        //start = System.currentTimeMillis();
        stopwatch.reset().start();
        stream.forEach(i -> i++);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        //System.out.println(System.currentTimeMillis() - start);
    }
}
