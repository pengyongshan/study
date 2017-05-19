package com.tree.www.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("请输入总人数：");
	    int n = scanner.nextInt(); // 输入总人数
	    int count = 0; // 判断数到3的。

	    // 初始化链表，把每个位置作为值加进链表。
	    List list = new LinkedList();//移除比ArrayList更快
	    for (int i = 1; i <= n; i++) {
	        list.add(i);
	    }
	    for (int i = 0; i < n - 1; i++) {//只留一个 循环n-1次
	        count = (count + 2) % list.size();
	        // remove后后一个值取代了原来的值，+2就是下一个3
			System.out.println(" " + list.get(count) + "号出局");
	        list.remove(count);
	    } 
	    System.out.println("留下人的位置是原来的" + list.get(0) + "号。");
	}
}
