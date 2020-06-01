package com.tree.www.leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 * <p>
 * Created by pysh on 2020-03-27.
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("+42"));
        System.out.println(new MyAtoi().myAtoi("-00000000000000000000000042"));
        System.out.println(new MyAtoi().myAtoi("   -42"));
        System.out.println(new MyAtoi().myAtoi("421122aaaaad"));
        System.out.println(new MyAtoi().myAtoi("a421122aaaaad"));
        System.out.println(new MyAtoi().myAtoi("-1172718281818178278421122aaaaad"));
        System.out.println(new MyAtoi().myAtoi("20000000000000000000"));
    }

    public int myAtoi(String str) {
        String string = str.trim();
        if (string.length() == 0 || (string.charAt(0) != '+' && string.charAt(0) != '-' &&
                !Character.isDigit(string.charAt(0)))) {
            return 0;
        }
        long sign = 1;
        if (string.charAt(0) == '-') {
            sign = -1;
        }

        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        int maxlen = String.valueOf(Integer.MAX_VALUE).length() + 2;
        for (int i = Character.isDigit(chars[0]) ? 0 : 1, len = chars.length; i < len; i++) {
            char c = chars[i];
            if (c == '0' && sb.length() == 0) {
                continue;
            }
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
            if (sb.length() > maxlen) break;
        }
        if (sb.length() == 0) return 0;

        long temp = Long.valueOf(sb.toString()) * sign;
        if (temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) temp;
    }
}
