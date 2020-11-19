package com.tree.www.test;

/**
 * Created by pysh on 2017/6/21.
 */
public class Test {

    public static void main(String[] args) {
        String string = "";
        System.out.println(string);
    }

    private static String longStr(int len) {
        String a = "";
        for (int i = 0; i < len; i++) {
            a += "a";
        }
        return a;
    }

}