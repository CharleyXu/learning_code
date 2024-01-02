package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 72 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * horse -> rorse (将 'h' 替换为 'r')
 * <p>
 * rorse -> rose (删除 'r')
 * <p>
 * rose -> ros (删除 'e')
 */
public class MinInstance {

    /**
     * 时间复杂度 O(mn)
     */
    public int minDistance(String word1, String word2) {

        // dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
        int n1 = word1.length();
        int n2 = word2.length();
        // 有一个字符串为空串
        if (n1 * n2 == 0) {
            return n1 + n2;
        }
        // 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
        //
        //当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        //
        // dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        // 第一列
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n1][n2];
    }

    @Test
    public void minDistanceTest() {
        System.out.println(minDistance("intention", "execution"));
    }
}
