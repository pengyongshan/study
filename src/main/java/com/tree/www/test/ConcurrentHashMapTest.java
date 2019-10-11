package com.tree.www.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pysh on 2019-09-27.
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", 123);
        map.putIfAbsent("han", 234);
        map.putIfAbsent("r2", 345);
        map.putIfAbsent("c3", 456);

        String reduced = map.reduce(1, (key, value) -> key + "=" + value,
                (s1, s2) -> s1 + ", " + s2);

        System.out.println(reduced);
    }
}
