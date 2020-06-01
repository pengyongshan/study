package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * Created by pysh on 2020-06-01.
 */
public class Leetcode260 {

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // xor = x ^ y
        // 保留最后边是1的。eg: 11010 & (-11010) = 11010 & 00010 = 00010
        // x, y 只有1个数后面那位是1. 都是1的话 ^ 就是0了。
        int temp = xor & (-xor);
        for (int num : nums) {
            if ((num & temp) != 0) { // 过滤掉后边那位【非1的】和【重复的】
                ans[0] ^= num;
            }
        }
        ans[1] = xor ^ ans[0];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leetcode260().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
