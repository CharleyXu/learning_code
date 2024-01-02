package com.xu.algorithm.dp;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * <p>
 * 300 最长递增子序列
 * <p>
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * <p>
 * 输出：4
 * <p>
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class LengthOfLIS {

    /**
     * 时间复杂度O(n2)
     */
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
