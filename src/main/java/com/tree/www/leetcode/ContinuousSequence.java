package com.tree.www.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 * <p>
 * Created by pysh on 2020-03-30.
 */
public class ContinuousSequence {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ContinuousSequence().findContinuousSequence(9)));
    }

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> rest = new ArrayList<>();
        int max = (int) Math.sqrt(target + 1.0) *2;
        for (int i = max; i >= 2; i--) {
            int[] ints = new int[i];
            if (i % 2 == 0) {
                if (target % i == i / 2) {
                    if (target / i - i / 2 + 1 <= 0) continue;
                    for (int j = 0; j < i; j++) {
                        ints[j] = target / i - i / 2 + 1 + j;
                    }
                }
            } else {
                if (target % i == 0) {
                    if (target / i - i / 2 <= 0) continue;
                    for (int j = 0; j < i; j++) {
                        ints[j] = target / i - i / 2 + j;
                    }
                }
            }
            if (ints[0] <= 0) continue;
            rest.add(ints);
        }
        return rest.toArray(new int[0][]);
    }
}
