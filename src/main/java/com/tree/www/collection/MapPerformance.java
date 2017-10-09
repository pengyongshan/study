package com.tree.www.collection;

import com.google.common.collect.Maps;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * map性能测试
 * <p>
 * Created by pysh on 2017/10/9.
 */
public class MapPerformance {
    private static final int REPS = 200;

    public static Map fill(Map map, int size) {
        for (int i = 0; i < size; i++) {
            String x = Integer.toString(i);
            map.put(x, x);
        }
        return map;
    }

    public static void main(String[] args) {
        test(Maps.newHashMap(), 10);
        test(new Hashtable(), 10);
        test(new TreeMap(), 10);
        System.out.println();

        test(Maps.newHashMap(), 100);
        test(new Hashtable(), 100);
        test(new TreeMap(), 100);
        System.out.println();

        test(Maps.newHashMap(), 1000);
        test(new Hashtable(), 1000);
        test(new TreeMap(), 1000);
    }

    public static void test(Map map, int size) {
        System.out.println("Testing " + map.getClass().getName() + " size " + size);
        fill(map, size);
        for (Tester test : tests) {
            System.out.print(test.name);
            long t1 = System.currentTimeMillis();
            test.test(map, size);
            long t2 = System.currentTimeMillis();
            System.out.println(": " + ((double) (t2 - t1)) / size);
        }
    }

    private abstract static class Tester {
        String name;

        Tester(String name) {
            this.name = name;
        }

        abstract void test(Map map, int size);
    }

    private static Tester[] tests = {
            new Tester("put") {
                @Override
                void test(Map map, int size) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < size; j++) {
                            map.clear();
                            fill(map, size);
                        }
                    }
                }
            },
            new Tester("iteration") {
                @Override
                void test(Map map, int size) {
                    for (int i = 0; i < REPS; i++) {
                        Iterator iterator = map.entrySet().iterator();
                        while (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                }
            },
            new Tester("get") {
                @Override
                void test(Map map, int size) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < size; j++) {
                            map.get(Integer.toString(j));
                        }
                    }
                }
            },
    };
}
