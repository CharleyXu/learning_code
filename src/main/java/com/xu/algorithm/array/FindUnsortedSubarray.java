package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 581 最短无序连续子数组
 * <p>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * <p>
 * 输出：5
 * <p>
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序
 */
public class FindUnsortedSubarray {

    /**
     * 时间复杂度 O(N)
     * <p>
     * 3段，左段和右段是升序数组，找中间数组的左右边界 begin和end
     * <p>
     * 从左到右维护一个最大值max，end就是最后一个小于max元素的位置。如果进入了右段，就没有比最大值小的数
     * <p>
     * 从右到左维护一个最大值min，begin就是最后一个大于min元素的位置。如果进入了左段，就没有比最小值大的数
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
            if (min < nums[n - i - 1]) {
                start = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return end == -1 ? 0 : end - start + 1;
    }

    /**
     * 时间复杂度 O(nlogn)
     */
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) {
            i++;
        }
        while (i <= j && nums[j] == arr[j]) {
            j--;
        }
        return j - i + 1;
    }

    @Test
    public void findUnsortedSubarrayTest() {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

}
