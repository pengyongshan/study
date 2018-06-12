package com.tree.www.java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口
 * <p>
 * Created by pysh on 2018/6/7.
 */
public class PredicateDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        eval(list, n -> true);
        eval(list, n -> n % 2 == 0);
        eval(list, n -> n > 2);
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }
}
