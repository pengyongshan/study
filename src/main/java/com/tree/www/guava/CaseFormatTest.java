/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.guava;

import com.google.common.base.CaseFormat;

/**
 * 
 * 驼峰 下划线 中划线 格式互相转换
 * @author pengyongshan
 *
 * @version $Id: CaseFormatTest.java, v 0.1 2016年12月15日 下午4:01:07 pengyongshan Exp $
 */
public class CaseFormatTest {

    
    public static void main(String[] args) {
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, "ls-lsls"));
    }
}
