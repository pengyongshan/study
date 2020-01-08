/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.test;

/**
 * @author pengyongshan
 * @version $Id: Study.java, v 0.1 2016年9月29日 下午2:30:12 pengyongshan Exp $
 */
public class Study {

    public static void main(String[] args) throws Exception {
        //int[] a = {1, 3, 4, 5, 7};
        //int[] b = {5, 6, 8, 9, 10};
        //System.out.println(getValueByIndex(a,b, 0));
        //System.out.println(getValueByIndex(a,b, 1));
        //System.out.println(getValueByIndex(a,b, 2));
        //System.out.println(getValueByIndex(a,b, 3));
        //System.out.println(getValueByIndex(a,b, 4));
        //System.out.println(getValueByIndex(a,b, 5));
        //System.out.println(getValueByIndex(a,b, 6));
        //System.out.println(getValueByIndex(a,b, 7));
        //System.out.println(getValueByIndex(a,b, 8));
        //System.out.println(getValueByIndex(a,b, 9));
        //System.out.println(getValueByIndex(a,b, 10));
        soutOtherString("abcD");
    }

    public static void soutOtherString(String str) {
        int length = str.length();
        if (length >= 32) {
            // TODO
            return;
        }
        char[] lower = str.toLowerCase().toCharArray();
        char[] upper = str.toUpperCase().toCharArray();

        for (int i = 0; i <= (1 << str.length()) - 1; i++) {
            StringBuilder temp = new StringBuilder(Integer.toBinaryString(i));
            for (int j = 0, len = length - temp.length(); j < len; j++) {
                temp.insert(0, "0");
            }
            String current = temp.toString();
            StringBuilder toOut = new StringBuilder();
            for (int k = 0; k < length; k++) {
                final char c = current.charAt(k);
                toOut.append(c == '0' ? lower[k] : upper[k]);
            }
            if (str.equals(toOut.toString())) {
                continue;
            }
            System.out.println(toOut.toString());
        }
    }

    public static int getValueByIndex(int[] a, int[] b, int index) throws Exception {
        if (index >= a.length + b.length || index < 0) {
            throw new Exception("index error");
        }
        int indexa = 0, indexb = 0;
        while (index-- > 0) {
            if (a[indexa] < b[indexb]) {
                if (++indexa == a.length) {
                    return index < 0 ? a[a.length - 1] : b[indexb + index];
                }
            } else {
                if (++indexb == b.length) {
                    return index < 0 ? b[b.length - 1] : a[indexa + index];
                }
            }
        }
        return Math.min(a[indexa], b[indexb]);
    }

}
