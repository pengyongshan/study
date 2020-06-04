package com.tree.www.leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pysh on 2020-06-03.
 */
public class Leetcode210 {

    /**
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * <p>
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * <p>
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] ld = new int[numCourses];
        Set<Integer>[] sets = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            sets[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            sets[prerequisite[1]].add(prerequisite[0]);
            ld[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ld[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            res[index++] = num;
            for (Integer integer : sets[num]) { // sets里存着以num为前提的
                if (--ld[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{0, 1}, {1, 0}};
        final int[] order = new Leetcode210().findOrder(2, ints);
        System.out.println(Arrays.toString(order));
    }
}
