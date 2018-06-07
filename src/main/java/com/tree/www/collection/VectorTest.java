package com.tree.www.collection;

import java.util.Vector;

/**
 * Created by pysh on 2018/6/6.
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.addElement("aaaa");
        vector.addElement("bbbb");
        vector.addElement("cccc");
        vector.addElement("dddd");
        for (String s : vector) {
            System.out.println(s);
        }
    }
}
