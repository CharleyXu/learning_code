package com.xu.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by CharleyXu on 2024/1/3
 * <p>
 * 523. 连续的子数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，
 * <p>
 * 编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * <p>
 * 子数组元素总和为 k 的倍数。
 * <p>
 * 如果存在，返回 true ；否则，返回 false
 * <p>
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * <p>
 * 输出：true
 * <p>
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6
 */
public class CheckSubarraySum {

    /**
     * 前缀树 + HashSet
     * <p>
     * sum[j]−sum[i−1]= n∗k，通过简单变形，两者除 k 相减为整数，并满足取余相同
     *
     * <p>
     * 时间复杂度 O(n)
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和 数组
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 前缀树 + HashMap
     * <p>
     * sum[j]−sum[i−1]= n∗k，通过简单变形，两者除 k 相减为整数，并满足取余相同
     *
     * <p>
     * 时间复杂度 O(n)
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

}
