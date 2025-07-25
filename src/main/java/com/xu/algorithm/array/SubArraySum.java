package com.xu.algorithm.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 560 和为k的子数组
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * <p>
 * 输出：2
 */
public class SubArraySum {

    /**
     * 假设数组的前缀和数组为prefixSum，其中prefixSum[i]表示从数组起始位置到第i个位置的元素之和。
     * <p>
     * 那么对于任意的两个下标i和j（i < j），
     * <p>
     * 如果prefixSum[j] - prefixSum[i] = k，即从第i个位置到第j个位置的元素之和等于k，那么说明从第i+1个位置到第j个位置的连续子数组的和为k。
     * <p>
     * 通过遍历数组，计算每个位置的前缀和，并使用一个哈希表来存储每个前缀和出现的次数。
     * <p>
     * 在遍历的过程中，我们检查是否存在prefixSum[j] - k的前缀和，
     * <p>
     * 如果存在，说明从某个位置到当前位置的连续子数组的和为k，我们将对应的次数累加到结果中。
     * <p>
     * 这样，通过遍历一次数组，我们可以统计出和为k的连续子数组的个数，并且时间复杂度为O(n)，其中n为数组的长度。
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 初始化前缀和为0的次数为1

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 2, 3, 4, 5, 7, 8, 9, 10};
        int num = 12;
        System.out.println(subarraySum(arr, num));
    }

}
