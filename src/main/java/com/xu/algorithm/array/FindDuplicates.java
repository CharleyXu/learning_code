package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CharleyXu Created on 2019/3/18.
 * <p>
 * 442-数组中重复的数据
 * <p>
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）,
 * <p>
 * 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:  [4,3,2,7,8,2,3,1]
 * <p>
 * 输出: [2,3]
 */
public class FindDuplicates {

    /**
     * 在数组中找出所有重复出现的数，
     *
     * <p>
     * 要求时间复杂度O(n),空间复杂度O(1)
     * <p>
     * 使用正负号作为标记
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }

    /**
     * 将元素交换到对应的位置
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                // 说明位置i与位置nums[i]上的元素相同，直接返回该重复元素
                res.add(nums[i]);
            }
        }
        return res;
    }

    @Test
    public void findDuplicatesTest() {
        int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
    }


    /**
     * 287. 寻找重复数
     * <p>
     * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内
     * <p>
     * 请找出数组中任意一个重复的数字
     * <p>
     * <p>
     * <p>
     * 0～n-1 范围内的数，分别还原到对应的位置上，如：数字 2 交换到下标为 2 的位置。
     * <p>
     * 若交换过程中发现重复，则直接返回
     */
    public int duplicateInArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    // 说明位置i与位置nums[i]上的元素相同，直接返回该重复元素
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    /**
     * 不修改数组查找重复的元素，没有则返回0
     * <p>
     * <p>
     * 数组元素的取值范围是 [1, n]，对该范围对半划分，
     * <p>
     * 分成 [1, middle], [middle+1, n]。计算数组中有多少个(count)元素落在 [1, middle] 区间内，
     * <p>
     * 如果 count 大于 middle-1+1，那么说明这个范围内有重复元素，否则在另一个范围内。继续对这个范围对半划分，继续统计区间内元素数量。
     * <p>
     * 时间复杂度 O(n * log n)，空间复杂度 O(1)。
     * <p>
     * 注意，此方法无法找出所有重复的元素
     */
    public int duplicateInArray2(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
