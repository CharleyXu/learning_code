package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * No33 搜索旋转排序数组
 * <p>
 * 「二分」的本质是两段性，并非单调性。
 * <p>
 * 只要一段满足某个性质，另外一段不满足某个性质，就可以用「⼆分」。
 */
public class SearchRotationSortArray {

    /**
     * 通过二分搜索找旋转点
     * <p>
     * 对旋转点进行二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 找到满足 > nums[0]的分割点，旋转点
        int left = 0;
        int right = n - 1;
        int middle;
        while (left < right) {
            middle = (left + right + 1) >> 1;
            if (nums[middle] >= nums[0]) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        if (target >= nums[0]) {
            left = 0;
        } else {
            left = left + 1;
            right = n - 1;
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;

    }

    /**
     * 朴素搜索
     * <p>
     * O(n)
     */
    public int simpleSearch(int[] nums, int target) {
        int right = nums.length - 1;
        int inx = 0;
        // 找旋转点
        for (int i = 0; i < right; i++) {
            if (nums[i] > nums[i + 1]) {
                inx = i;
                break;
            }
        }
        System.out.println(inx);
        int result = binarySearch(nums, 0, inx, target);
        if (result != -1) {
            return result;
        }
        if (inx + 1 < nums.length) {
            result = binarySearch(nums, inx + 1, right, target);
        }
        return result;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int middle;
        while (left <= right) {
            middle = (left + right) >> 1;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    @Test
    public void searchTest() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

}
