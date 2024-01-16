package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 228 汇总区间
 * <p>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * <p>
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * <p>
 * 输出：["0->2","4->5","7"]
 */
public class SummaryRanges {

    /**
     * 双指针
     * <p>
     * 时间复杂度 O(N)
     */
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (j + 1 == n || nums[j + 1] != nums[j] + 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                i = j + 1;
            }
        }
        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low < high) {
                sb.append("->").append(nums[high]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    @Test
    public void summaryRangesTest() {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
        System.out.println(summaryRanges2(nums));
    }

}
