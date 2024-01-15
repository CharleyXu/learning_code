package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 647 回文子串
 * <p>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 输入：s = "aaa"
 * <p>
 * 输出：6
 * <p>
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class CountSubstrings {

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
     * <p>
     * 时间复杂度 O(N2)
     */
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            // left和right指针和中心点的关系
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // left = i/2, right = left + i%2
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

    /**
     * DP
     * <p>
     * 时间复杂度 O(N2)
     * <p>
     * 空间复杂度 O(N2)
     */
    public int countSubstringsDp(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void countSubstringsTest() {
        String s = "aaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstringsDp(s));
    }
}
