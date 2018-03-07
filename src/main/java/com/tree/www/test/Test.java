package com.tree.www.test;

/**
 * Created by pysh on 2017/6/21.
 */
public class Test {

    public static void main(String[] args) {
        for (int i = 7; i >= 0; i--) {
            if (((1L << i) & -3) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
        System.out.println(~ 2);
        throw new NullPointerException();
    }

}
