package com.xu.algorithm.binary;

import java.util.Collections;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 524 通过删除字母匹配到字典里最长单词
 * <p>
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，
 * <p>
 * 该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * <p>
 * 输出："apple"
 */
public class FindLongestWord {

    /**
     * 排序 + 二分 + 贪心
     * <p>
     * m是dictionary的长度，排序时间复杂度 O(mlogm)
     * <p>
     * 整体复杂度 O(mlogm + m * n)
     * <p>
     */
    public String findLongestWord(String s, List<String> dictionary) {
        // 排序
        Collections.sort(dictionary, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        //
        int n = s.length();
        for (String ss : dictionary) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == m) {
                return ss;
            }
        }
        return "";
    }

}
