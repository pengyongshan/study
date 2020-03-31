package com.tree.www.leetCode;

/**
 * 892. 三维形体的表面积
 * <p>
 * Created by pysh on 2020-03-26.
 */
public class SurfaceArea {

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(new SurfaceArea().surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {
        if (grid.length == 0) return 0;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    result += 2;
                    for (int k = 0; k < 4; k++) {
                        if (i + dr[k] >= 0 && j + dc[k] >= 0
                                && i + dr[k] < grid.length && j + dc[k] < grid[0].length) {
                            result += Math.max(0, grid[i][j] - grid[i + dr[k]][j + dc[k]]);
                        } else {
                            result += grid[i][j];
                        }
                    }
                }
            }
        }
        return result;
    }
}
