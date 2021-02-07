package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 2021/2/6.
 */
public class Leetcode1423 {

	/**
	 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
	 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
	 * 你的点数就是你拿到手中的所有卡牌的点数之和。
	 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
	 *
	 * @param cardPoints
	 * @param k
	 * @return
	 */
	public int maxScore(int[] cardPoints, int k) {
		// 动态规划
		int[] left = new int[k+1];
		int[] right = new int[k+1];
		int len = cardPoints.length;
		for(int i=1; i <= k; i++) {
			left[i] = cardPoints[i-1] + left[i-1];
		}

		int max = left[k];
		for(int i = 1; i <= k; i++) {
			right[i] = cardPoints[len-i] + right[i-1];
			max = Math.max(max, right[i] + left[k-i]);
		}
		return max;
	}

	public int maxScore2(int[] cardPoints, int k) {
		// 滑动窗口
		int len = cardPoints.length;
		int windowSize = len - k, windowSum =0;
		for(int i=0; i < windowSize; i++) {
			windowSum += cardPoints[i];
		}
		int min = windowSum, sum = windowSum;
		for(int i = windowSize; i < len; i++) {
			windowSum = windowSum + cardPoints[i] - cardPoints[i-windowSize];
			min = Math.min(min, windowSum);
			sum += cardPoints[i];
		}
		return sum - min;
	}
}
