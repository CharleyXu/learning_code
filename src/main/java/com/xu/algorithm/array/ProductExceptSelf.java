package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 238 除自身以外 数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
 * <p>
 * 在 O(n) 时间复杂度内完成此题
 * <p>
 * 输入: nums = [1,2,3,4]
 * <p>
 * 输出: [24,12,8,6]
 */
public class ProductExceptSelf {

    /**
     * 左右乘积列表
     * <p>
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    /**
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(1)
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        return ans;
    }

    @Test
    public void productExceptSelfTest() {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

}
