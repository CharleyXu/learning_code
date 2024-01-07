package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2020-06-09
 * <p>
 * 在排序数组中查找数字
 */
public class Search {

    /**
     * 只找到左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int count = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int middle = (low + high) >> 1;
            if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] >= target) {
                high = middle;
            }
        }
        while (low < nums.length && nums[low++] == target) {
            count++;
        }
        return count;
    }
}
