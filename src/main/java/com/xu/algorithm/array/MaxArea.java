package com.xu.algorithm.array;

import org.junit.Test;

/**
 * 11 盛最多水的容器
 * <p>
 * Container With Most Water
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class MaxArea {

    /**
     * 双指针
     * <p>
     * 时间复杂度 O(N)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int low = 0, high = height.length - 1;
        int max = 0;
        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);

            max = Math.max(max, area);
            if (height[low] <= height[high])
                low++;
            else
                high--;
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int low = 0, high = height.length - 1, res = 0;
        while (low < high) {
            res = height[low] < height[high] ? Math.max(res, (high - low) * height[low++]) :
                    Math.max(res, (high - low) * height[high--]);
        }
        return res;
    }

    @Test
    public void maxAreaTest() {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

}
