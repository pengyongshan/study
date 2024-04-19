package com.tree.www.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pysh on 2021/8/24.
 */
public class Leetcode787 {
  /**
   * 有 n 个城市通过一些航班连接。给你一个数组flights ，
   * 其中flights[i] = [fromi, toi, pricei] ，
   * 表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
   * <p>
   * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，
   * 你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。
   * 如果不存在这样的路线，则输出 -1。
   *
   * @param n
   * @param flights
   * @param src
   * @param dst
   * @param k
   * @return
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] flight : flights) {
      if (map.containsKey(flight[0])) {
        map.get(flight[0]).put(flight[1], flight[2]);
      } else {
        map.put(flight[0], new HashMap<>(Collections.singletonMap(flight[1], flight[2])));
      }
    }
    dfs(map, src, dst, k+1, 0);
    if (result == Integer.MAX_VALUE) {
      return -1;
    }
    return result;
  }

  int result = Integer.MAX_VALUE;
  private void dfs(Map<Integer, Map<Integer, Integer>> map, int src, int dst, int k, int sum) {
    if (sum >= result || k < 0) return;
    if (src == dst) {
      result = sum;
      return;
    }
    if (!map.containsKey(src)) {
      return;
    }
    Map<Integer, Integer> subMap = map.get(src);
    for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
      dfs(map, entry.getKey(), dst, k-1, sum + entry.getValue());
    }
  }

  public static void main(String[] args) {
    final Leetcode787 leetcode787 = new Leetcode787();
    int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    System.out.println(leetcode787.findCheapestPrice(3, flights, 0, 2, 1));
    System.out.println(leetcode787.findCheapestPrice2(3, flights, 0, 2, 1));
  }

  public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
    final int INF = 10000 * 101 + 1;
    int[] f = new int[n];
    Arrays.fill(f, INF);
    f[src] = 0;
    int ans = INF;
    for (int t = 1; t <= k + 1; ++t) {
      int[] g = new int[n];
      Arrays.fill(g, INF);
      for (int[] flight : flights) {
        int j = flight[0], i = flight[1], cost = flight[2];
        g[i] = Math.min(g[i], f[j] + cost);
      }
      f = g;
      ans = Math.min(ans, f[dst]);
    }
    return ans == INF ? -1 : ans;
  }
}
