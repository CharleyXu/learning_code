package com.xu.algorithm.structure.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by CharleyXu on 2020-06-11
 * <p>
 * <p>
 * 151
 * 给定一个字符串，
 * <p>
 * 需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 */
public class ReverseWords {

    /**
     * 使用api
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 双指针
     * <p>
     * <p>
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(n)
     */
    public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int j = s.length() - 1, i = j;
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    /**
     * 双指针
     * <p>
     * <p>
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(n)
     */
    public String reverseWords2(String s) {
        // trim掉 前后的空串
        StringBuilder sb = trimSpace(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转每一个字符串
        reverseEachWord(sb);
        // join
        return sb.toString();
    }

    private StringBuilder trimSpace(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        // 去除字符串之间多余的空串
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    private void reverse(StringBuilder s, int left, int right) {
        while (left < right) {
            char c = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, c);
            left++;
            right--;
        }
    }

    /*反转每一个单词*/
    private void reverseEachWord(StringBuilder s) {
        int length = s.length();
        int start = 0, end = 0;
        while (start < length) {
            while (end < length && s.charAt(end) != ' ') {
                end++;
            }
            reverse(s, start, end - 1);
            // 更新start，寻找下一个单词
            start = end + 1;
            end++;
        }
    }

    @Test
    public void reverseWordsTest() {
        String s = "the sky is blue";
        System.out.println(reverseWords2(s));
        System.out.println(reverseWords3(s));
    }

}
