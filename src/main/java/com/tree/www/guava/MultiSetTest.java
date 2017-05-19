/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 可重复Set
 * @author pengyongshan
 *
 * @version $Id: MultiSetTest.java, v 0.1 2016年12月13日 下午2:18:25 pengyongshan Exp $
 */
public class MultiSetTest {

    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        System.out.println(multiset.size());
        System.out.println(multiset.elementSet().size());
        System.out.println(multiset.count("a"));
        multiset.remove("b");
        System.out.println(multiset.size());
        System.out.println(multiset.elementSet().size());
        System.out.println(multiset.count("b"));
    }
}
