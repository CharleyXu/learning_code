package com.xu.algorithm.structure.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/17.
 * <p>
 * 回文字符串
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

    @Test
    public void isPalindromeTest() {
        //A man, a plan, a canal: Panama
        //race a car
        String string = "A man, a plan, a canal: Panama";
        boolean palindromeByReverse = isPalindromeByTwoPointer(string);
        System.out.println(palindromeByReverse);
    }


}
