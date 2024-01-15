package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 189 轮转数组
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * <p>
 * 输出: [5,6,7,1,2,3,4]
 */
public class Rotate {

    /**
     * 使用额外数组
     * <p>
     * 时间复杂度 O(N)
     * <p>
     * 空间复杂度 O(N)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[(i + k) % n] = nums[i];
        }
        System.arraycopy(array, 0, nums, 0, n);
    }

    /**
     * 数组翻转
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 环状替换
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    @Test
    public void rotateTest() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        int[] clone = nums.clone();
        rotate2(nums, 3);
        System.out.println(Arrays.toString(clone));
    }

}
