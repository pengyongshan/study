package com.tree.www.collection;

import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Set;

/**
 * set性能测试
 * <p>
 * Created by pysh on 2017/10/9.
 */
public class SetPerformance {
    private static final int REPS = 200;

    private abstract static class Tester {
        String name;

        Tester(String name) {
            this.name = name;
        }

        abstract void test(Set s, int size);
    }

    public static void main(String[] args) {
        test(Sets.newHashSet(), 10);
        test(Sets.newTreeSet(), 10);
        System.out.println();

        test(Sets.newHashSet(), 1000);
        test(Sets.newTreeSet(), 1000);
        System.out.println();

        test(Sets.newHashSet(), 100000);
        test(Sets.newTreeSet(), 100000);
    }

    public static void test(Set set, int size) {
        System.out.println("Testing " + set.getClass().getName() + " size " + size);
        fills(set, size);
        for (int i = 0; i < testers.length; i++) {
            System.out.print(testers[i].name);
            long t1 = System.currentTimeMillis();
            testers[i].test(set,size);
            long t2 = System.currentTimeMillis();
            System.out.println(": " + ((double)(t2 - t1))/size);
        }
    }

    private static Tester[] testers = {
            new Tester("add") {
                @Override
                void test(Set s, int size) {
                    for (int i = 0; i < REPS; i++) {
                        s.clear();
                        fills(s, size);
                    }
                }
            },
            new Tester("contains") {
                @Override
                void test(Set s, int size) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < size; j++) {
                            s.contains(Integer.toString(j));
                        }
                    }
                }
            },
            new Tester("iteration") {
                @Override
                void test(Set s, int size) {
                    for (int i = 0; i < REPS; i++) {
                        Iterator iterator = s.iterator();
                        while (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                }
            }
    };

    private static void fills(Set s, int size) {
        for (int i = 0; i < size; i++) {
            s.add(String.valueOf(i));
        }
    }
}
