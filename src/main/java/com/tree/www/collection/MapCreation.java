package com.tree.www.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * 各种map的创建速度
 * <p>
 * Created by pysh on 2017/10/9.
 */
public class MapCreation {
    public static void main(String[] args) {
        final long REPS = 100000000;
        long t1 = System.currentTimeMillis();
        System.out.print("Hashtable: ");
        for(long i = 0; i < REPS; i++) {
            new Hashtable<>();
        }
        System.out.println(System.currentTimeMillis() - t1);

        t1 = System.currentTimeMillis();
        System.out.print("TreeMap: ");
        for(long i = 0; i < REPS; i++) {
            new TreeMap<>();
        }
        System.out.println(System.currentTimeMillis() - t1);

        t1 = System.currentTimeMillis();
        System.out.print("HashMap: ");
        for(long i = 0; i < REPS; i++) {
            new HashMap<>();
        }
        System.out.println(System.currentTimeMillis() - t1);
    }
}
