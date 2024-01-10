package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/10
 * <p>
 * 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 输入：s = "aab"
 * <p>
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * <p>
 * 132 分割回文串 II
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数
 */
public class MinCut {

    /**
     * 分割回文串
     * <p>
     * 返回 s 所有可能的分割方案。
     * <p>
     * 回溯 + DP优化
     */
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        // 预处理
        // dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[n][n];
        // 单个字符是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (left == right) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1]);
                }
            }
        }
        backtrack(s, 0, s.length(), dp, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int i, int len, boolean[][] dp, List<String> state, List<List<String>> res) {
        // 记录解，停止搜索
        if (i == len) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int j = i; j < len; j++) {
            // 剪枝
//            if (!checkPalindrome(s, i, j)) {
//                continue;
//            }
            if (!dp[i][j]) {
                continue;
            }
            //尝试
            state.add(s.substring(i, j + 1));
            //
            backtrack(s, j + 1, len, dp, state, res);
            // 回退
            state.remove(state.size() - 1);
        }
    }

    /**
     * 是否回文子串，这里可以使用DP来做优化
     */
    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void partitionTest() {
        System.out.println(partition("aab"));
    }

    /**
     * 分割回文串 II
     */
    public int minCut(String s) {
        int n = s.length();
        //
        boolean[][] m = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = true;
        }
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (left == right) {
                    m[left][right] = true;
                } else {
                    m[left][right] = s.charAt(left) == s.charAt(right) && (right - left <= 2 || m[left + 1][right - 1]);
                }
            }
        }
        // 前缀s[0..i]的最少分割次数
        int[] f = new int[n];
        Arrays.fill(f, n);
        for (int i = 0; i < n; i++) {
            if (m[0][i]) {
                f[i] = 0;
            } else {
                // 字符串s[0,i]分割成s[0,j]和s[j+1,i]
                for (int j = 0; j < i; j++) {
                    if (m[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }

}
