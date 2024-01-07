package com.xu.algorithm.greedy;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 300 最长递增子序列
 */
public class LengthOfLIS {

    /**
     * 贪心 + 二分
     * <p>
     * 考虑一个简单的贪心，
     * <p>
     * 如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，
     * <p>
     * 因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
     * <p>
     * 基于上面的贪心思路，我们维护一个数组 d[i]，表示长度为 i 的最长上升子序列的末尾元素的最小值
     * <p>
     * 根据 d 数组的单调性，我们可以使用二分查找寻找下标 i
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len, pos = 0;
                while (left <= right) {
                    int middle = (left + right) >> 1;
                    if (d[middle] < nums[i]) {
                        pos = middle;
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    @Test
    public void lengthOfLISTest() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
