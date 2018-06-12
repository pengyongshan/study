/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 多值Map
 * 
 * @author pengyongshan
 *
 * @version $Id: MultiMapTest.java, v 0.1 2017年3月21日 上午11:19:22 pengyongshan Exp $
 */
public class MultiMapTest {

    public static void main(String[] args) {
        Multimap<String, String>  map = ArrayListMultimap.create();
        map.put("pys", "15088694492");
        map.put("pys", "13333");
        map.put("sss", "15088694492");
        map.put("qqq", "15088694492");
        
        System.out.println(map.size());
        System.out.println(map.get("pys"));
        
    }
}
