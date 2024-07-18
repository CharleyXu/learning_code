package com.xu.algorithm.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/17.
 * <p>
 * 125. 验证回文串
 */
public class PalindromeString {

    /**
     * 筛选加判断，时间复杂度O(｜s｜)，｜s｜是字符串s的长度
     * <p>
     * 或者可以直接在原字符串上直接判断
     */
    public boolean isPalindromeByTwoPointer(String s) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(Character.toLowerCase(ch));
            }
        }
        int n = result.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (result.charAt(left) != result.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    /**
     * 1332 删除回文子序列
     *
     * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
     * <p>
     * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数
     * <p>
     * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
     * <p>
     * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
     */
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }

    @Test
    public void isPalindromeTest() {
        //A man, a plan, a canal: Panama
        //race a car
        String string = "A man, a plan, a canal: Panama";
        boolean palindromeByReverse = isPalindromeByTwoPointer(string);
        System.out.println(palindromeByReverse);
    }


}
