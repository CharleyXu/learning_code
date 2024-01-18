package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * No33 搜索旋转排序数组
 * <p>
 * 「二分」的本质是两段性，并非单调性。
 * <p>
 * 只要一段满足某个性质，另外一段不满足某个性质，就可以用「⼆分」
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * <p>
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 6
 * 输出：2
 */
public class SearchRotationSortArray {

    /**
     * 通过二分搜索找旋转点
     * <p>
     * <p>
     * O(logn)
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // 根据 nums[0] 与 target 的关系判断目标值是在左半段还是右半段
            // 转换为有序数组中找目标值
            if (target >= nums[0]) {
                // 目标值在左半段时，若 mid 在右半段，则将 mid 索引的值改成 inf
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 目标值在右半段时，若 mid 在左半段，则将 mid 索引的值改成 -inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 81 搜索旋转有序数组II
     * <p>
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同
     * <p>
     * 输入：nums = [2,5,6,0,0,1,2], target = 5
     * <p>
     * 输出：true
     * <p>
     * 对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]，
     * <p>
     * 此时无法判断区间 [l,mid] 和区间 [mid+1,r] 哪个是有序的
     */
    public boolean search2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    @Test
    public void searchTest() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
        int[] nums2 = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println(search2(nums2, 2));
    }

}
