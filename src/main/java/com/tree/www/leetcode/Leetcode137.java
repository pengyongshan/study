package com.tree.www.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * Created by pysh on 2020-06-01.
 */
public class Leetcode137 {

    public int singleNumber(int[] nums) {
        int onece = 0, twice = 0;
        for (int num : nums) {
            // 赋值前 onece = 0，twice = 0;
            // num出现第1次: onece = num & ~0 = num, twice = num & ~num = 0.
            // num出现第2次: onece = 0 & ~0 = 0; twice = num & ~0 = num.
            // num出现第3次: onece = num & ~num = 0; twice = 0 & ~0 = 0.
            onece = (onece ^ num) & ~twice;
            twice = (twice ^ num) & ~onece;
        }
        return onece;
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 1, 3, 2, 1, 1};
        System.out.println(new Leetcode137().singleNumber(num));
    }
}