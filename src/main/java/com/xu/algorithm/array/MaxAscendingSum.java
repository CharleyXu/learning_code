package com.xu.algorithm.array;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/2/18
 * <p>
 */
public class MaxAscendingSum {

    /**
     * 53 最大子数组和
     * <p>
     * 使用 Kadane 算法找到最大子数组和
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];  // 全局最大和
        int currentSum = nums[0];  // 当前子数组和

        for (int i = 1; i < nums.length; i++) {
            // 如果当前和为负，重新开始
            // 否则继续累加
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // 更新全局最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * 动态规划解法（与Kadane算法本质相同）
     */
    public int maxSubArrayDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    /**
     * 1800 最大升序子数组和
     * <p>
     * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
     * <p>
     * 子数组是数组中的一个连续数字序列。
     * <p>
     * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * <p>
     * 若对所有 i（l <= i < r），numsi  < numsi+1 都成立，则称这一子数组为 升序 子数组。
     * <p>
     * 注意，大小为 1 的子数组也视作 升序 子数组。
     * <p>
     * 时间复杂度：O(n)
     */
    public int maxAscendingSum(int[] nums) {
        int res = 0, left = 0, n = nums.length;
        while (left < n) {
            int cur = nums[left++];
            while (left < n && nums[left] > nums[left - 1]) {
                cur += nums[left++];
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    public int maxAscendingSum2(int[] nums) {
        int n = nums.length, ans = nums[0];
        for (int i = 1, cur = nums[0]; i < n; i++) {
            if (nums[i] > nums[i - 1]) cur += nums[i];
            else cur = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    @Test
    public void maxAscendingSumTest() {
        int[] nums = new int[]{12, 17, 15, 13, 10, 11, 12};
        System.out.println(maxAscendingSum(nums));
    }

}