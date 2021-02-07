package com.tree.www.leetcode;

/**
 * Created by pysh on 2021/2/6.
 */
public class Leetcode517 {

	/**
	 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
	 * <p>
	 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
	 * <p>
	 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。
	 * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
	 *
	 * @param machines
	 * @return
	 */
	public int findMinMoves(int[] machines) {
		int sum = 0, res = 0, n = machines.length;
		for (int load : machines) sum += load;
		if (sum % n != 0) return -1;
		int target = sum / n;
		int cnt = 0;
		for (int load : machines) {
			cnt += load - target;
			res = Math.max(res, Math.max(Math.abs(cnt), load - target));
		}
		return res;
	}

	public int findMinMoves2(int[] machines) {
		int n = machines.length;
		if (n == 1) return 0;
		int sum = 0;
		for (int machine : machines) {
			sum += machine;
		}
		if (sum % n != 0) return -1;

		int target = sum / n, min = 0;
		for (int i = 0; i < n; i++) {
			machines[i] -= target;
			min = Math.max(min, machines[i]);
		}

		int currSum = 0, res = min;
		for (int m : machines) {
			currSum += m;
			res = Math.max(res, Math.abs(currSum));
		}
		return res;
	}
}
