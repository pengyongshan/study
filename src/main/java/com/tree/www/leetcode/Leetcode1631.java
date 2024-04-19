package com.tree.www.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最小体力消耗路径
 * <p>
 * Created by pysh on 2021/1/29.
 */
public class Leetcode1631 {

	int[][] dirs = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

	/**
	 * 你准备参加一场远足活动。给你一个二维rows x columns的地图heights，
	 * 其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子(0, 0)，
	 * 且你希望去最右下角的格子(rows-1, columns-1)（注意下标从 0 开始编号）。
	 * 你每次可以往 上，下，左，右四个方向之一移动，你想要找到耗费体力最小的一条路径。
	 * <p>
	 * 一条路径耗费的体力值是路径上相邻格子之间高度差绝对值的最大值决定的。
	 * <p>
	 * 请你返回从左上角走到右下角的最小体力消耗值
	 * <p>
	 * ps:
	 * rows == heights.length
	 * columns == heights[i].length
	 * 1 <= rows, columns <= 100
	 * 1 <= heights[i][j] <= 10^6
	 *
	 * @param heights
	 * @return
	 */
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int left = 0, right = 999999, ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{0, 0});
			boolean[] seen = new boolean[m * n];
			seen[0] = true;
			while (!queue.isEmpty()) {
				int[] cell = queue.poll();
				int x = cell[0], y = cell[1];
				for (int i = 0; i < 4; ++i) {
					int nx = x + dirs[i][0];
					int ny = y + dirs[i][1];
					if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
									!seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
						queue.offer(new int[]{nx, ny});
						seen[nx * n + ny] = true;
					}
				}
			}
			if (seen[m * n - 1]) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	public int minimumEffortPath2(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int[] height : heights) {
			for (int j = 0; j < n; j++) {
				min = Integer.min(min, height[j]);
				max = Integer.max(max, height[j]);
			}
		}
		int left = 0, right = max - min, ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean[][] visited = new boolean[m][n];
			if (dfs(heights, 0, 0, mid, visited)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	private boolean dfs(int[][] heights, int i, int j, int threshold, boolean[][] visited) {
		if (i == heights.length - 1 && j == heights[0].length - 1) {
			return true;
		}
		visited[i][j] = true;
		for (int[] dir : dirs) {
			int x = i + dir[0], y = j + dir[1];
			if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length
							&& Math.abs(heights[x][y] - heights[i][j]) <= threshold && !visited[x][y]) {
				if (dfs(heights, i + dir[0], j + dir[1], threshold, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] height = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
		System.out.println(new Leetcode1631().minimumEffortPath2(height));
	}
}
