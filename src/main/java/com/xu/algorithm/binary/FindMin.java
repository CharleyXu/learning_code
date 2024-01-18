package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/7
 * <p>
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * <p>
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * <p>
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * <p>
 * 输出：1
 */
public class FindMin {

    /**
     * nums[mid]和nums[n - 1]的关系来决定收缩左右空间。
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, len = r;
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] > nums[len]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public int findMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            /* 先加一再除，mid更靠近右边的right */
            int mid = left + (right - left + 1) / 2;
            if (nums[left] < nums[mid]) {
                /* 向右移动左边界 */
                left = mid;
            } else if (nums[left] > nums[mid]) {
                /* 向左移动右边界 */
                right = mid - 1;
            }
        }
        /* 最大值向右移动一位就是最小值了（需要考虑最大值在最右边的情况，右移一位后对数组长度取余） */
        return nums[(right + 1) % nums.length];
    }

    /**
     * 154 寻找旋转排序数组中的最小值II
     * <p>
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到
     * <p>
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     * <p>
     * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     * <p>
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
     * <p>
     * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素
     * <p>
     * 你必须尽可能减少整个过程的操作步骤
     * <p>
     * 输入：nums = [1,3,5]
     * <p>
     * 输出：1
     */
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + high >> 1;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

    @Test
    public void findMinTest() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 4};
        System.out.println(findMin2(nums));
    }

}
