package com.xu.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/18.
 * <p>
 * 242 有效的字母异位词
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * <p>
 * 输出: true
 */
public class Anagram {

    /**
     * 使用数组或者集合
     * <p>
     * 将字符与字符‘a’相减转int值，数值范围在[0,25]之间
     * <p>
     * 时间复杂度：O(n), 空间复杂度：O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
            letter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void isAnagram() {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        Assert.assertTrue(anagram);
    }
}
