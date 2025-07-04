package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/12
 * <p>
 * 买卖股票的最佳时机
 * <p>
 */
public class MaxProfit {

    /**
     * 121
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润
     * <p>
     * 输入：[7,1,5,3,6,4]
     * <p>
     * 输出：5
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    @Test
    public void maxProfitTest() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    /**
     * 122 买卖股票的最佳时机 II
     * <p>
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润
     * <p>
     * 输入：prices = [7,1,5,3,6,4]
     * <p>
     * 输出：7
     * <p>
     * 4  + 3 = 7
     * <p>
     * 等价于每次选择贡献大于0的区间，使得答案最大化
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public int maxProfit2Dp(int[] prices) {
        int n = prices.length;
        // 定义dp[i][0] 交易完后，手里没有股票的最大利润
        // dp[i][1]，交易完后手里有一支股票的最大利润
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 123 买卖股票的最佳时机III
     * <p>
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * <p>
     * 输出：6
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * 309 买卖股票的最佳时机含冷冻期
     * <p>
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
     * <p>
     * 输入: prices = [1,2,3,0,2]
     * <p>
     * 输出: 3
     * <p>
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfit4(int[] prices) {
        // 持有股票 pre, 不持有股票处于冷冻期 f0，不持有股票不处于冷冻期 f1
        int pre = 0, f0 = 0, f1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int newF0 = Math.max(f0, f1 + price);
            f1 = Math.max(f1, pre - price);
            pre = f0;
            f0 = newF0;
        }
        return f0;
    }

    @Test
    public void maxProfit4Test() {
        int[] nums = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit4(nums));
    }


}
