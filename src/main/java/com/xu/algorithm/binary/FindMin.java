package com.xu.algorithm.binary;

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
            int mid = left + (right - left + 1) / 2;   /* 先加一再除，mid更靠近右边的right */
            if (nums[left] < nums[mid]) {
                left = mid;                            /* 向右移动左边界 */
            } else if (nums[left] > nums[mid]) {
                right = mid - 1;                       /* 向左移动右边界 */
            }
        }
        return nums[(right + 1) % nums.length];    /* 最大值向右移动一位就是最小值了（需要考虑最大值在最右边的情况，右移一位后对数组长度取余） */
    }

}
