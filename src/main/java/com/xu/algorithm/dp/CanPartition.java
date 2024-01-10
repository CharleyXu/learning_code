package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 输入：nums = [1,5,11,5]
 * <p>
 * 输出：true
 * <p>
 * 解释：数组可以分割成 [1, 5, 5] 和 [11]
 */
public class CanPartition {

    /**
     * 是否可以从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[n][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][target];
    }

    /**
     * 空间优化
     * <p>
     * 时间复杂度：O(NC)：这里 N 是数组元素的个数，C 是数组元素的和的一半；
     */
    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
