package com.xu.algorithm.twopointer.slidingwindow;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 209 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * <p>
 * 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * <p>
 * 如果不存在符合条件的子数组，返回 0
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * <p>
 * 输出：2
 * <p>
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 */
public class MinSubArrayLen {

    /**
     * 滑动窗口
     * <p>
     * 时间复杂度 O(n)
     */
    public int minSubArrayLenSliding(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 前缀和 + 二分
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int m = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, m);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
