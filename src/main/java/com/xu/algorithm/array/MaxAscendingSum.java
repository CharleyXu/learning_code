package com.xu.algorithm.array;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/2/18
 * <p>
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
 */
public class MaxAscendingSum {

    /**
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