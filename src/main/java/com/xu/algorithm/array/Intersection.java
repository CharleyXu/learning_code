package com.xu.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2020-06-09
 * <p>
 * 两个数组的交集
 */
public class Intersection {

    /**
     * 两个set
     * <p>
     * 或者 排序 + 双指针 + 一个 set
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                secondSet.add(nums2[i]);
            }
        }
        int[] nums = new int[secondSet.size()];
        int index = 0;
        for (int val : secondSet) {
            nums[index++] = val;
        }
        return nums;
    }
}
