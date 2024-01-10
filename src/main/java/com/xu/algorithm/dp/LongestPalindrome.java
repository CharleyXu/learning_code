package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * Created by CharleyXu on 2023/11/17
 * <p>
 * 最长回文子串
 */
public class LongestPalindrome {

    @Test
    public void longestPalindromeTest() {
        System.out.println(longestPalindrome("efe"));
    }

    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
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
                if (dp[left][right] && right - left >= res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }

}
