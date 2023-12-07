package com.xu.algorithm.structure.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2023/12/5
 * <p>
 * 268 丢失的数字
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

}
