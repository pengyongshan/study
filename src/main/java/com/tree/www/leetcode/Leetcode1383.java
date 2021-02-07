package com.tree.www.leetcode;

import java.util.*;

/**
 * 最大的团队表现值
 * <p>
 * Created by pysh on 2021/2/7.
 */
public class Leetcode1383 {

	public static void main(String[] args) {
		int[] speed = {2, 10, 3, 1, 5, 8};
		int[] efficiency = {5, 1, 1, 1, 1, 1, 1};
		System.out.println(new Leetcode1383().maxPerformance(6, speed, efficiency, 3));
	}

	/**
	 * (9,1)
	 * (7,5)
	 * (5,2)
	 * (4,10)
	 * (3,3)
	 * (2,8)
	 * <p>
	 * 公司有编号为 1到 n的 n个工程师，给你两个数组 speed和 efficiency，
	 * 其中 speed[i]和 efficiency[i]分别代表第 i位工程师的速度和效率。
	 * 请你返回由最多k个工程师组成的最大团队表现值，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
	 * <p>
	 * 团队表现值的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」
	 *
	 * @param n
	 * @param speed
	 * @param efficiency
	 * @param k
	 * @return ps:
	 * 1 <= n <= 10^5
	 * speed.length == n
	 * efficiency.length == n
	 * 1 <= speed[i] <= 10^5
	 * 1 <= efficiency[i] <= 10^8
	 * 1 <= k <= n
	 */
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		final int mod = 1000_000_007;
		List<Staff> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(new Staff(speed[i], efficiency[i]));
		}
		list.sort((s1, s2) -> s2.e - s1.e);
		PriorityQueue<Staff> queue = new PriorityQueue<>(Comparator.comparingInt(staff -> staff.s));
		long ans = 0, sum = 0;
		for (int i = 0; i < n; ++i) {
			Staff staff = list.get(i);
			sum += staff.s;
			ans = Math.max(ans, sum * staff.e);
			queue.offer(staff);
			if (queue.size() == k) {
				sum -= Objects.requireNonNull(queue.poll()).s;
			}
		}
		return (int) (ans % mod);
	}

	static class Staff {
		int s, e;

		public Staff(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
