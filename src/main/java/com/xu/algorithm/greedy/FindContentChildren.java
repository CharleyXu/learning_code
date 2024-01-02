package com.xu.algorithm.greedy;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 455 分发饼干
 * <p>
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。
 * <p>
 * 每个孩子只能吃 最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩 子可以吃饱。
 * <p>
 * 输入两个数组，分别代表孩子的饥饿度和饼干的大小。输出最多有多少孩子可以吃饱的数量。
 */
public class FindContentChildren {

    /**
     * 排序 + 双指针 + 贪心
     * <p>
     * 时间复杂度 O(mlogm + nlogn)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = 0, n = 0;
        while (m < g.length && n < s.length) {
            if (g[m] <= s[n]) {
                m++;
            }
            n++;
        }
        return m;
    }

}
