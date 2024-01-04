package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class MinPathSum {

    /**
     * 时间复杂度为 𝑂(𝑛𝑚)
     * <p>
     * 空间复杂度 O(nm)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 初始化 dp 表 dp[i][j] 表示从左上角开始到 (i, j) 位置的最 优路径的数字和
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 状态转移，首行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 状态转移，首列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 状态转移，其余行列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 时间复杂度为 𝑂(𝑛𝑚)
     * 空间复杂度 O(m)
     */
    int minPathSumDPComp(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 初始化 dp 表
        int[] dp = new int[m];
        // 状态转移:首行
        dp[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        // 状态转移:其余行
        for (int i = 1; i < n; i++) {
            // 状态转移:首列
            dp[0] = dp[0] + grid[i][0];
            // 状态转移:其余列
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[m - 1];

    }

}
