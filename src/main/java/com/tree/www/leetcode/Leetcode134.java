package com.tree.www.leetcode;

/**
 * 加油站 https://leetcode-cn.com/problems/gas-station/
 * <p>
 * Created by pysh on 11/18/20.
 */
public class Leetcode134 {

    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
     * 你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * <p>
     * 说明: 
     * <p>
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                if (check(i, gas, cost, gas[i] - cost[i], 0)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean check(int i, int[] gas, int[] cost, int balance, int times) {
        if (times > gas.length) {
            return true;
        }
        int next = i + 1;
        if (next == gas.length) {
            next = 0;
        }
        balance = gas[next] - cost[next] + balance;
        return balance >= 0 && check(next, gas, cost, balance, ++times);
    }


    /**
     * 我们首先检查第 0 个加油站，并试图判断能否环绕一周；
     * 如果不能，就从不能的地方继续开始检查
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int[] balance = new int[len];
        for (int i = 0; i < len; i++) {
            balance[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < len; i++) {
            if (balance[i] >= 0) {
                int times = len, b = balance[i];
                while (--times > 0) {
                    b = b + balance[(++i) % len];
                    if (b < 0) break;
                }
                if (times == 0) return (i + 1) % len;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Leetcode134().canCompleteCircuit2(gas, cost));
    }
}
