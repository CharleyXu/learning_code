package com.xu.algorithm.string;

import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-18
 * <p>
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * <p>
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
 */
public class ReverseStr {

    /**
     * 输入: s = "abcdefg", k = 2
     * <p>
     * 输出: "bacdfeg"
     */
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            swap(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }


    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            char swap = arr[left];
            arr[left++] = arr[right];
            arr[right--] = swap;
        }
    }

    @Test
    public void reverseStrTest() {
        System.out.println(reverseStr("abcdefg", 2));
    }

}
