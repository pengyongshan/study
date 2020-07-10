package com.tree.www.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by pysh on 2020-06-29.
 */
public class Leetcode739 {

    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
     * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!deque.isEmpty() && T[deque.peek()] < T[i]) {
                int pre = deque.pop();
                T[pre] = i - pre;
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            T[deque.pop()] = 0;
        }
        return T;
    }

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new Leetcode739().dailyTemperatures(nums)));
    }
}
