/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Date;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: Study.java, v 0.1 2016年9月29日 下午2:30:12 pengyongshan Exp $
 */
public class Study {

    public static void main(String[] args) throws ClassNotFoundException {
        Date date = new Date();
        System.out.println(JSON.parseObject("1525261320053", Date.class));
    }
}
