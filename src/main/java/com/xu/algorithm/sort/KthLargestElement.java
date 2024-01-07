package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/3
 * <p>
 * 215. 在一个未排序的数组中，找到第 k 大的数字。
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * <p>
 * Output: 5
 */

public class KthLargestElement {

    /**
     * 快速选择算法，找到第 k 大的枢(pivot)
     * <p>
     * 时间复杂度 O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("invalid input");
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int x = nums[l], i = l, j = r;
        while (i < j) {
            while (nums[i] < x) {
                i++;
            }
            while (nums[j] > x) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k <= j) {
            return quickSelect(nums, l, j, k);
        } else {
            return quickSelect(nums, j + 1, r, k);
        }
    }


    /*交换*/
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void findKthLargestTest() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

}
