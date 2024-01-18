package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/18
 * <p>
 * 31 下一个排列
 * <p>
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列
 * <p>
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2]
 * <p>
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2]
 * <p>
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列
 * <p>
 * 给你一个整数数组 nums ，找出 nums 的下一个排列
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 */
public class NextPermutation {

    /**
     * 从后往前找，找到第一个下降的位置k
     * <p>
     * 从k往后找，找到比k大的最小数
     * <p>
     * 两者交换
     * <p>
     * 直接将k以后的部分翻转
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        int k = n - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) {
            k--;
        }
        if (k == 0) {
            reverse(nums, 0, n - 1);
        } else {
            int u = k;
            while (u < n - 1 && nums[u + 1] > nums[k - 1]) {
                u++;
            }
            swap(nums, k - 1, u);
            reverse(nums, k, n - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        int l = start, r = end;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    @Test
    public void nextPermutationTest() {
        int[] nums = new int[]{1, 2, 1, 7, 8, 6, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
