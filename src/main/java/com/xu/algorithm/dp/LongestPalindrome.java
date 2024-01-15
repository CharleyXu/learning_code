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
        System.out.println(longestPalindrome2("efe"));
    }

    /**
     * DP
     */
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                dp[left][right] = s.charAt(left) == s.charAt(right) && (right - left < 2 || dp[left + 1][right - 1]);
                if (dp[left][right] && right - left >= res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }

    /**
     * 中心扩展法
     * <p>
     * 比如对一个字符串 ababa，选择最中间的 a 作为中心点，往两边扩散，
     * <p>
     * 第一次扩散发现 left 指向的是 b，right 指向的也是 b，所以是回文串，继续扩散，同理 ababa 也是回文串
     * <p>
     * 最终的中心点由 2 * len - 1 个，分别是 len 个单字符和 len - 1 个双字符
     * <p>
     * aba 有5个中心点，分别是 a、b、c、ab、ba
     * <p>
     * 中心点即 left 指针和 right 指针初始化指向的地方，可能是一个也可能是两个
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                String temp = s.substring(left, right + 1);
                if (temp.length() > res.length()) {
                    res = temp;
                }
                left--;
                right++;
            }
        }
        return res;
    }

}
