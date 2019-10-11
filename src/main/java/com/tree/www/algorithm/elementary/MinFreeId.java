package com.tree.www.algorithm.elementary;

/**
 * 最小可用ID
 *
 * 非负整数数组中表示used ids. 求可用的最小ID
 * <p>
 * Created by pysh on 2019-10-11.
 */
public class MinFreeId {

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 6, 9, 8, 7, 11, 12, 10, 0, 5};
        System.out.println(minFreeId(num));
    }

    private static int minFreeId(int[] num) {
        // l 左边界， u 右边界, n 剩余数数量
        int l = 0, u = num.length - 1, t, n = num.length;
        while (n > 0) {
            // 二分
            int left = 0, right, m = (u + l) / 2;
            for (right = l; right < n + l; right++) {
                if (num[right] <= m) {
                    t = num[left + l];
                    num[left + l] = num[right];
                    num[right] = t;
                    left++;
                }
            }
            if (left == m - l + 1) {
                l = m + 1;
                n -= left;
            } else {
                n = left;
                u = m;
            }
        }
        return l;
    }

}
