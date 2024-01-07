package com.xu.algorithm.twopointer.slidingwindow;

import java.util.TreeSet;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 220 存在重复元素
 * <p>
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * <p>
 * 找出满足下述条件的下标对 (i, j)：
 * <p>
 * i != j,
 * <p>
 * abs(i - j) <= indexDiff
 * <p>
 * abs(nums[i] - nums[j]) <= valueDiff
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * <p>
 * 输出：true
 * <p>
 * 解释：可以找出 (i, j) = (0, 3)
 */
public class ContainsNearbyAlmostDuplicate {

    /**
     * 滑动窗口 + 二分
     * <p>
     * 使用有序集合（红黑树），去维护长度为k的滑动窗口内的数
     * <p>
     * 支持查询、插入/删除
     * <p>
     * 时间复杂度: TreeSet 查询和插入都是O(logk)的复杂度
     * <p>
     * 整体时间复杂度是 O(nlogk)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        // treeSet
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long num = (long) nums[i];
            // 从ts中找到小于等于num的最大值
            Long l = treeSet.floor(num);
            // 从ts中找到大于等于num的最小值
            Long r = treeSet.ceiling(num);
            if (l != null && num - l <= valueDiff) {
                return true;
            }
            if (r != null && r - num <= valueDiff) {
                return true;
            }
            treeSet.add(num);
            if (i >= indexDiff) {
                treeSet.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

}
