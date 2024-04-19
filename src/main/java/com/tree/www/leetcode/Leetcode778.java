package com.tree.www.leetcode;

/**
 * 水位上升的泳池中游泳
 * <p>
 * Created by pysh on 2021/2/6.
 */
public class Leetcode778 {

	/**
	 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
	 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
	 * 你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
	 * 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
	 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)
	 * <p>
	 * 2 <= N <= 50.
	 * grid[i][j] 是 [0, ..., N^2 - 1] 的排列。
	 *
	 * @param grid
	 * @return
	 */
	public int swimInWater(int[][] grid) {
		N = grid.length;
		int left = Math.max(grid[0][0], grid[N - 1][N - 1]);
		left = Math.max(left, (N-1) * 2);

		int right = N * N - 1;
		while (left < right) {
			int t = (left + right) / 2;
			boolean[][] visited = new boolean[N][N];
			if (dfs(grid, 0, 0, visited, t)) {
				right = t;
			} else {
				left = t + 1;
			}
		}
		return left;
	}

	int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	int N = 0;

	private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int t) {
		visited[x][y] = true;
		for (int[] direction : DIRECTIONS) {
			int newX = x + direction[0];
			int newY = y + direction[1];
			if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= t) {
				if (newX == N - 1 && newY == N - 1) {
					return true;
				}

				if (dfs(grid, newX, newY, visited, t)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean inArea(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
