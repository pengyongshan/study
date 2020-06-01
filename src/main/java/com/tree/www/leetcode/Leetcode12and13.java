package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-05-25.
 */
public class Leetcode12and13 {

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * 输入确保在 1 到 3999 的范围内。
     *
     * @param num
     * @return
     */
    private static String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] NUMS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num >= NUMS[index]) {
                sb.append(ROMANS[index]);
                num -= NUMS[index];
            } else {
                index++;
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        int result = 0, index = 0;
        while (s.length() != 0) {
            if (s.startsWith(ROMANS[index])) {
                result += NUMS[index];
                s = s.substring(index % 2 == 0 ? 2 : 1);
            } else {
                index++;
            }
        }
        return result;
    }
}
