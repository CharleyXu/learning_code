package com.xu.algorithm.binary.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 219 存在重复元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，
 * <p>
 * 判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * <p>
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            int num = nums[i];
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
