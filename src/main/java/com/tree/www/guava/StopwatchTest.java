/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.guava;


import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: StopwatchTest.java, v 0.1 2016年12月12日 下午7:26:13 pengyongshan Exp $
 */
public class StopwatchTest {

    public static void main(String[] args) {
        Stopwatch s = Stopwatch.createStarted();
        int sum = 0;
        for(int i=0; i<100000; i ++) {
            sum +=i;
        }
        System.out.println(sum);
        Stopwatch s1 = s.stop();
        System.out.println(s1.elapsed(TimeUnit.NANOSECONDS));
        System.out.println(s1.elapsed(TimeUnit.MILLISECONDS));
    }
}
