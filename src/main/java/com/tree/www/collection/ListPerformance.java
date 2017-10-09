package com.tree.www.collection;

import com.google.common.collect.Lists;

import java.util.*;


/**
 * list性能测试
 * <p>
 * Created by pysh on 2017/10/9.
 */
public class ListPerformance {
    private static final int REPS = 100;

    public static void test(List a) {
        System.out.println("Testing " + a.getClass().getName());
        for (Tester tester : testers) {
            fills(a, tester.size);
            System.out.print(tester.name);
            long t1 = System.currentTimeMillis();
            tester.test(a);
            long t2 = System.currentTimeMillis();
            System.out.println(":" + (t2 - t1));
        }
    }

    public static void main(String[] args) {
        test(Lists.newArrayList());
        System.out.println();
        test(Lists.newLinkedList());
    }

    private static void fills(List<String> a, int size) {
        for(int i = 0; i < size; i++) {
            a.add("test" + i);
        }
    }

    private abstract static class Tester {
        String name;
        int size;

        Tester(String name, int size) {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    private static Tester[] testers = {
            new Tester("get", 5000) {
                @Override
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < a.size(); j++) {
                            a.get(i);
                        }
                    }
                }
            },
            new Tester("iteration", 5000) {
                @Override
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        Iterator iterator = a.iterator();
                        while (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                }
            },
            new Tester("insert", 5000) {
                @Override
                void test(List a) {
                    int half = a.size() / 2;
                    String s = "test";
                    ListIterator iterator = a.listIterator(half);
                    for (int i = 0; i < size * 10; i++) {
                        iterator.add(s);
                    }
                }
            },
            new Tester("remove", 5000) {
                @Override
                void test(List a) {
                    ListIterator iterator = a.listIterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                    }
                }
            }
    };

}
