package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 爬楼梯， 𝑛 阶的楼梯，你每步可以上 1 阶或者 2 阶，请问有多少种方案可以爬到楼顶
 */
public class ClimbingStairsDPComp {

    /* 爬楼梯:空间优化后的动态规划
     *
     * 𝑑𝑝[𝑖] = 𝑑𝑝[𝑖 − 1] + 𝑑𝑝[𝑖 − 2]
     *
     * f(x)=f(x−1)+f(x−2)
     * */
    public int climbStairs(int n) {
        int a = 0, b = 0, c = 1;
        for (int i = 1; i <= n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    /**
     * 给定一个共有 𝑛 阶的楼梯，你每步可以上 1 阶或者 2 阶，但不能连续两轮跳 1 阶，请问有多 少种方案可以爬到楼顶。
     * <p>
     * 带约束爬楼梯
     * <p>
     * {𝑑𝑝[𝑖, 1] = 𝑑𝑝[𝑖 − 1, 2]
     * 𝑑𝑝[𝑖, 2] = 𝑑𝑝[𝑖 − 2, 1] + 𝑑𝑝[𝑖 − 2, 2]
     *
     * dp[n][1] + dp[n][2]
     */

    int climbingStairsConstraintDP(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 初始化 dp 表，用于存储子问题的解
        int[][] dp = new int[n + 1][3];
        // 初始状态:预设最小子问题的解
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        // 状态转移:从较小子问题逐步求解较大子问题
        for (int i = 3; i <= n; i++) {
            dp[i][1] = dp[i - 1][2];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
        }
        return dp[n][1] + dp[n][2];
    }

    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * <p>
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * <p>
     * dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
     */
    /* 爬楼梯最小代价:空间优化后的动态规划 */
    int minCostClimbingStairsDPComp(int[] cost) {
        int n = cost.length;
        int pre = 0, cur = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }
        return cur;
    }

}
