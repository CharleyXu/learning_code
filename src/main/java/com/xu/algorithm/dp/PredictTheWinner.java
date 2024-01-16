package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 486 预测赢家
 * <p>
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏
 * <p>
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 * <p>
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 输入：nums = [1,5,2]
 * <p>
 * 输出：false
 */
public class PredictTheWinner {

    /**
     * 说成净胜分 ，语义会更强一些。
     * <p>
     * 甲乙比赛，甲先手面对区间[i...j]时，dp[i][j]表示甲对乙的净胜分。
     * <p>
     * 最终求的就是，甲先手面对区间[0...n-1]时，甲对乙的净胜分dp[0][n-1]是否>=0。
     * <p>
     * 甲先手面对区间[i...j]时，
     * <p>
     * 如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]
     * <p>
     * 如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]
     * <p>
     * 以上两种情况二者取大即可。
     */
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i][j] 等于当数组剩下的部分为下标i到下标j时，当前玩家与另一个玩家的分数之差的最大值，
        // 只有当i<=j时，数组剩下的部分才有意义。i>j时 dp[i][j] =0
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    /**
     * 877 石子游戏
     * <p>
     * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
     * <p>
     * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
     * <p>
     * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
     * <p>
     * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }

    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }


}
