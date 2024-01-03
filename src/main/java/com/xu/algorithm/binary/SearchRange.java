package com.xu.algorithm.binary;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2023/11/20
 * <p>
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * <p>
 * 找出给定目标值在数组中的开始位置和结束位置。 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 输入:nums = [5,7,7,8,8,10], target = 8
 * <p>
 * 输出:[3,4]
 */
public class SearchRange {

    @Test
    public void searchRangeTest() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + right >> 1;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                res = middle;
                // 继续左侧寻找
                right = middle - 1;
            }
        }
        return res;
    }

    private int findLast(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + right >> 1;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                res = middle;
                // 继续在右侧寻找
                left = res + 1;
            }
        }
        return res;
    }

}
