package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 198 打家劫舍
 */
public class HouseRobber {

    /**
     * DP
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
