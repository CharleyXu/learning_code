package com.xu.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 763 划分字母区间
 * <p>
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 输入：s = "ababcbacadefegdehijhklij"
 * <p>
 * 输出：[9,7,8]
 * <p>
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij"
 */
public class PartitionLabels {

    /**
     * 时间复杂度 O(n)
     */
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        // 记录每个字母出现的最后位置
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }

}
