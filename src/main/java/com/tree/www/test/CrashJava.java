package com.tree.www.test;

import java.util.Vector;

/**
 * Created by pysh on 2017/9/23.
 */
public class CrashJava {
    @Override
    public String toString() {
        return "CrashJava address：" + super.toString() + "\n";
        //return "CrashJava address：" + this.toString() + "\n";
    }

    public static void main(String[] args) {
        Vector<CrashJava> vector = new Vector<>();
        for(int i = 0; i < 10; i ++) {
            vector.add(new CrashJava());
        }
        System.out.println(vector);
    }
}
