package com.xu.algorithm.binary;

import java.util.Collections;
import java.util.List;

/**
 * Created by CharleyXu on 2024/2/7
 * <p>
 * 2824. 统计和小于目标的下标对数目
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 * <p>
 * 输入：nums = [-1,1,2,3,1], target = 2
 * <p>
 * 输出：3
 */
public class CountPairs {

    /**
     * 排序 + 双指针
     * <p>
     * 遍历左端点，在左端点右侧找最大合法右端点
     * <p>
     * 时间复杂度: O(nlogn)
     * <p>
     * 空间复杂度: O(logn)
     */
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0;
        for (int i = 0, j = nums.size() - 1; i < j; i++) {
            while (i < j && nums.get(i) + nums.get(j) >= target) {
                j--;
            }
            ans += j - i;
        }
        return ans;
    }

}
