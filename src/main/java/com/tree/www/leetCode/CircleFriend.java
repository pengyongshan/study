package com.tree.www.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 朋友圈问题
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * Created by pysh on 2019-05-15.
 */
public class CircleFriend {

    public static void main(String[] args) {
        int[][] M1 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] M2 = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        int[][] M3 = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        int[][] M4 = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(new CircleFriend().findCircleNum(M1));
        System.out.println(new CircleFriend().findCircleNum(M2));
        System.out.println(new CircleFriend().findCircleNum(M3));
        System.out.println(new CircleFriend().findCircleNum(M4));
    }

    private static int NUM;

    /**
     * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
     * 表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道
     *
     * @param M
     * @return 所有学生中的已知的朋友圈总数。
     */
    public int findCircleNum(int[][] M) {
        NUM = M.length; // 学生数量

        int circleNum = 0;

        int[] visit = new int[NUM];
        Arrays.fill(visit, 0);

        for (int i = 0; i < NUM; i++) {
            if (visit[i] == 0) {
                //bfs(visit, M, i);
                dfs(visit, M, i);
                circleNum++;
            }
        }
        return circleNum;
    }

    // DFS 深度优先
    private void dfs(int[] visit, int[][] m, int i) {
        for (int j = 0; j < NUM; j++) {
            if (m[i][j] == 1 && visit[j] != 1) {
                visit[j] = 1;
                dfs(visit, m, j);
            }
        }
    }

    // BFS 广度优先
    private void bfs(int[] visit, int[][] m, int i) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 0; j < NUM; j++) {
                if (m[temp][j] == 1 && visit[j] != 1) {
                    visit[j] = 1;
                    queue.add(j);
                }
            }
        }
    }
}
