package com.xu.algorithm.string;

import org.junit.Test;

/**
 * Created by CharleyXu on 2023/12/22
 * <p>
 * 28 找出字符串中第一个匹配项的下标
 * <p>
 * 给你两个字符串 haystack 和 needle ，
 * <p>
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * <p>
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Strstr {

    /**
     * 让 needle与haystack所有长度为m的子串，均匹配一次
     * <p>
     * 时间复杂度 O(m * (n-m))
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void strStrTest() {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

}
