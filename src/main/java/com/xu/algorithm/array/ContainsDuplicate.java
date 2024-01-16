package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 217 存在重复元素
 * <p>
 * 给你一个整数数组 nums 。如果任一值在数组中出现至少两次 ，返回true ；
 * <p>
 * 如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * <p>
 * 输出：true
 */
public class ContainsDuplicate {

    /**
     * 时间复杂度 O(N)
     * <p>
     * 空间复杂度 O(N)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度 O(Nlogn)
     * <p>
     * 空间复杂度 O(logN)
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void containsDuplicateTest() {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

}
