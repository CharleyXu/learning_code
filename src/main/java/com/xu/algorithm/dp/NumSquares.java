package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 279 完全平方数
 * <p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 输入：n = 12
 * <p>
 * 输出：3
 * <p>
 * 解释：12 = 4 + 4 + 4
 */
public class NumSquares {

    /**
     * 时间复杂度 O(n * 根号n)
     */
    public int numSquares(int n) {
        // dp[i] 最少需要多少个数的平方来表示整数 i
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

}
