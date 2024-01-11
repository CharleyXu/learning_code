package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 403 青蛙过河
 */
public class CanCross {

    /**
     * 时间复杂度 O(n2)
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // dp[i][k] 表示青蛙能否到达[现在所处的石子编号]为 i 且[上次跳跃距离]为 k 的状态
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

}
