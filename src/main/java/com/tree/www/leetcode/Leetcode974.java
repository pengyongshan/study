package com.tree.www.leetcode;

/**
 * 和可被 K 整除的子数组
 * <p>
 * Created by pysh on 2020-05-27.
 */
public class Leetcode974 {

    /**
     * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     * <p>
     * 1 <= A.length <= 30000
     * -10000 <= A[i] <= 10000
     * 2 <= K <= 10000
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len];
        int rest = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            dp[i] = sum % K;
            if (dp[i] == 0) {
                rest++;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[j] = (dp[j] - dp[i]) % K;
                if (dp[j] == 0) {
                    rest++;
                }
            }
        }
        return rest;
    }

    // 前缀和同模法排列组合
    private int subarraysDivByK2(int[] A, int K) {
        int[] modK = new int[K];
        modK[0] = 1; // 默认的【可整除的】先加1.因为【可整除的】单个也算

        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            int modulus = Math.floorMod(sum, K);//(sum % K + K) % K;

            // 原始里面有多少个对K同模的，就有几个连续数组。等价于排列组合(和握手问题差不多)
            ans += modK[modulus]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.floorMod(-10, 3));
    }
}
