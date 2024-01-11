package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 152 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 输入: nums = [2,3,-2,4]
 * <p>
 * 输出: 6
 * <p>
 * 解释: 子数组 [2,3] 有最大乘积 6
 */
public class MaxProduct {

    /**
     * 时间复杂度 O(N)
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
