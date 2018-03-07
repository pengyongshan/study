package com.tree.www.test;

/**
 * Created by pysh on 2017/10/19.
 */
public class LoseMessage {
    public static void main(String[] args) throws Exception {
        try {
            throw new Exception("xxx");
        } finally {
            throw new Exception("yyyy");
        }
    }
}
