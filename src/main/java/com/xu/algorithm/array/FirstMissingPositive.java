package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2023/12/5
 * <p>
 * 41. 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        // 原地置换，将数组视为哈希表，把1放到下标为0的位置，把2放到下标为1的位置...
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // [1,-1,3,4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确
        return len + 1;
    }

}
