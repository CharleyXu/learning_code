package com.xu.algorithm.array;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 162 寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * <p>
 * 输入：nums = [1,2,3,1]
 * <p>
 * 输出：2
 * <p>
 * 解释：3 是峰值元素，你的函数应该返回其索引 2
 */
public class FindPeakElement {

    /**
     * 找最大值
     * <p>
     * 时间复杂度 O(n)
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    /**
     * 二分, 二分的本质是「二段性」而非「单调性」
     * <p>
     * 对于任意数组而言，一定存在峰值
     * <p>
     * 二分不会错过峰值
     * <p>
     * 如果当前位置大于其左边界或者右边界，那么在当前位置的右边或左边必然存在峰值
     * <p>
     * 对于一个满足 nums[x]>nums[x+1]的位置，x 的左边一定存在峰值
     * <p>
     * 始终选择大于边界一端进行二分，可以确保选择的区间一定存在峰值，并随着二分过程不断逼近峰值位置。
     *
     * <p>
     * 时间复杂度 O(logN)
     */
    public int findPeakElementBinary(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + r >> 1;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    @Test
    public void findPeakElementBinaryTest() {
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElementBinary(nums));
    }

}
