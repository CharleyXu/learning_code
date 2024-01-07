package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2020-06-10
 * <p>
 * 最长公共前缀
 * <p>
 * 查找字符串数组中的最长公共前缀
 */
public class LongestCommonPrefix {

    /**
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
                if (str.isEmpty()) return "";
            }
        }
        return str;
    }
}
