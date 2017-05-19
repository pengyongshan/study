/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分法查找
 * 
 * @author pengyongshan
 *
 * @version $Id: BinarySearch.java, v 0.1 2016年11月15日 下午4:49:09 pengyongshan Exp $
 */
public class BinarySearch {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 5 };
        System.out.println("数组a为:" + Arrays.toString(a));
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.println("请输入要在数组中查找的数(-1退出):");
        while ((n = scanner.nextInt()) != -1) {
            int index = Arrays.binarySearch(a, n);
            //search(a, n);
            if (index >= 0) {
                System.out.println(n + "在数组a的第" + (index + 1) + "位");
            } else  {
                System.out.println(n + "不在数组a中,可以插入到第" + -(index + 1) + "位后面");
            }
            System.out.println("请继续输入要在数组中查找的数(-1退出):");
        }
        System.out.println("退出成功");
    }

    @SuppressWarnings("unused")
    private static int search(int[] a, int value) {
        int left = 0;
        int right = a.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) >> 1;
            if (a[middle] > value) {
                right = middle - 1;
            } else if (a[middle] < value) {
                left = middle + 1;
            } else {
                return middle + 1;
            }
        }
        return -middle;
    }
}
