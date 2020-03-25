package com.tree.www.algorithm.uniquePaths;

/**
 * 不同路径 3
 * <p>
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 * <p>
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 * <p>
 * Created by pysh on 2020-01-19.
 */
public class UniquePaths3 {

    // num 记录数量， startC, startR，起始位置；step总步数
    static int num = 0, startC = 0, startR = 0, step = 0;

    public static void main(String[] args) {
        int[][] test = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(uniquePathsIII(test));
        System.out.println(uniquePathsIII2(test));
    }

    public static int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        int rlen = grid.length, clen = grid[0].length;
        step = rlen * clen;
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
                if (grid[i][j] == -1) {
                    step--;
                }
            }
        }
        if (grid[startR][startC] != 1) {
            throw new IllegalArgumentException("未设置起始位置");
        }
        dfs(grid, startR, startC, 1);
        return num;
    }

    private static void dfs(int[][] grid, int currentR, int currentC, int currentStep) {
        if (grid[currentR][currentC] == 2) {
            if (currentStep == step) {
                num++;
            }
            return;
        } else {
            // 设置障碍
            grid[currentR][currentC] = -1;
        }
        // 访问上下左右4个节点，不越界且可访问
        if (currentR - 1 >= 0 && grid[currentR - 1][currentC] >= 0) {
            dfs(grid, currentR - 1, currentC, currentStep + 1);
        }
        if (currentC - 1 >= 0 && grid[currentR][currentC - 1] >= 0) {
            dfs(grid, currentR, currentC - 1, currentStep + 1);
        }
        if (currentR + 1 < grid.length && grid[currentR + 1][currentC] >= 0) {
            dfs(grid, currentR + 1, currentC, currentStep + 1);
        }
        if (currentC + 1 < grid[0].length && grid[currentR][currentC + 1] >= 0) {
            dfs(grid, currentR, currentC + 1, currentStep + 1);
        }
        // 恢复节点
        grid[currentR][currentC] = 0;
    }

    public static int uniquePathsIII2(int[][] grid) {
        int sum = 1, r = 0, c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    sum++;
                } else if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        return dfs2(grid, r, c, sum);
    }

    public static int dfs2(int[][] g, int i, int j, int sum) {
        // 越界或障碍
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == -1) {
            return 0;
        }
        // 抵达终点，步数够说明所有方格都跑过,否则此路不通
        if (g[i][j] == 2) {
            return sum == 0 ? 1 : 0;
        }
        int ans = 0;

        g[i][j] = -1;
        // 访问上下左右4个节点
        ans += dfs2(g, i + 1, j, sum - 1);
        ans += dfs2(g, i - 1, j, sum - 1);
        ans += dfs2(g, i, j + 1, sum - 1);
        ans += dfs2(g, i, j - 1, sum - 1);
        g[i][j] = 0;
        return ans;
    }

}
