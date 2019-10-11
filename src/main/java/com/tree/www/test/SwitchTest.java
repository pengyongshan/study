package com.tree.www.test;

/**
 * Created by pysh on 2019-05-15.
 */
public class SwitchTest {
    public static void main(String[] args) {
        switchIntTest(1);
        switchStringTest();
    }

    private static void switchIntTest(int a) {
        switch (a) {
            case 2:
                System.out.println("print 2");
            case 1:
                System.out.println("print 1");
            default:
                System.out.println("first print default");
            case 3:
                System.out.println("print 3");
        }
    }

    private static void switchStringTest() {
        String param = null;
        switch (param) {
            case "param":
                System.out.println("print param");
                break;
            case "String":
                System.out.println("print String");
                break;
            case "null":
                System.out.println("print null");
                break;
            default:
                System.out.println("second print default");
        }
    }
}
