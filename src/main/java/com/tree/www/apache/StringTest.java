/**
 * qccr.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.tree.www.apache;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: StringTest.java, v 0.1 2017年3月21日 上午11:39:44 pengyongshan Exp $
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "asabcacn ajjks  hshasa";
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.isNumeric(str));
        System.out.println(StringUtils.left(str, 2));
        System.out.println(StringUtils.countMatches(str, "a"));
        System.out.println(RandomStringUtils.randomAscii(10));
        System.out.println(RandomStringUtils.randomAlphabetic(10));
        System.out.println(RandomStringUtils.randomNumeric(10));
        System.out.println(WordUtils.capitalize(str));
    }
}
