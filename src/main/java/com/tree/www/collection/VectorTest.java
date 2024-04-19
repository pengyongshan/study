package com.tree.www.collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pysh on 2018/6/6.
 */
public class VectorTest {
    public static void main(String[] args) {
        final ExecutorService service = Executors.newWorkStealingPool();
        service.submit(() -> System.out.println("11"));
    }
}
