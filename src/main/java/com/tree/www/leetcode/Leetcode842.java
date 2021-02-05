package com.tree.www.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * <p>
 * Created by pysh on 12/8/20.
 */
public class Leetcode842 {

    /**
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     * <p>
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     * <p>
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     * <p>
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     *
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, S.length(), 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0') {
                // 0开头，位数只能为1.
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                // 数字在Integer范围内
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                int sum = list.get(list.size() - 1) + list.get(list.size() - 2);
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, S, length, i + 1)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode842().splitIntoFibonacci("11011121"));
    }
}
