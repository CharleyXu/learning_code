package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 169 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * <p>
 * 输出：3
 */
public class MajorityElement {

    /**
     * 时间复杂度 O(nlogn)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票
     * <p>
     * 核心理念为 票数正负抵消
     * <p>
     * 若记 众数 的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的 票数和 >0 。
     * <p>
     * 若数组的前a个数字的票数和=0 ，则 数组剩余 (n−a) 个数字的 票数和一定仍 >0 ，即后 (n−a) 个数字的 众数仍为 x
     *
     * <p>
     * 时间复杂度 O(n)
     */
    public int majorityElement2(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            vote += (num == x) ? 1 : -1;
        }
        return x;
    }

    /*
     * 摩尔投票 + 验证 x 是否为众数
     */
    public int majorityElement3(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;

        } // 验证 x 是否为众数
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }
        // 当无众数时返回 0
        return count > nums.length / 2 ? x : 0;
    }

    @Test
    public void majorityElementTest() {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }


}
