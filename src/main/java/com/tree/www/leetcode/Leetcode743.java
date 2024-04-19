package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 2021/8/2.
 */
public class Leetcode743 {

  /**
   * 有 n 个网络节点，标记为1到 n。
   * <p>
   * 给你一个列表times，表示信号经过 有向 边的传递时间。
   * times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
   * <p>
   * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
   * <p>
   * 1 <= k <= n <= 100
   * 1 <= times.length <= 6000
   * times[i].length == 3
   * 1 <= ui, vi <= n
   * ui != vi
   * 0 <= wi <= 100
   * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
   *
   * @param times
   * @param n
   * @param k
   * @return
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    final int INF = Integer.MAX_VALUE / 2;
    int[][] g = new int[n][n];
    for (int i = 0; i < n; ++i) {
      Arrays.fill(g[i], INF);
    }
    for (int[] t : times) {
      int x = t[0] - 1, y = t[1] - 1;
      g[x][y] = t[2];
    }

    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    dist[k - 1] = 0;
    boolean[] used = new boolean[n];
    for (int i = 0; i < n; ++i) {
      int x = -1;
      for (int y = 0; y < n; ++y) {
        if (!used[y] && (x == -1 || dist[y] < dist[x])) {
          x = y;
        }
      }
      used[x] = true;
      for (int y = 0; y < n; ++y) {
        dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
      }
    }

    int ans = Arrays.stream(dist).max().getAsInt();
    return ans == INF ? -1 : ans;
  }
}
