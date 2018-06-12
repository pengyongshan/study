/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.guava;

import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

/**
 * 过滤
 * 
 * @author pengyongshan
 *
 * @version $Id: MapsTest.java, v 0.1 2017年3月21日 上午11:27:33 pengyongshan Exp $
 */
public class MapsTest {

    public static void main(String[] args) {
        Map<String, Integer> users = Maps.newHashMap();
        users.put("zs", 18);
        users.put("lis", 17);
        users.put("ww", 20);
        System.out.println("成年人：" + Maps.filterValues(users, input -> input != null && input >= 18));
    }
}
