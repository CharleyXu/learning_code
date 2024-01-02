package com.xu.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 435 无重叠区间
 * <p>
 * 给定多个区间，计算让这些区间互不重叠所需要移除区间的最少个数。起止相连不算重叠。
 * <p>
 * 输入是一个数组，数组由多个长度固定为 2 的数组组成，表示区间的开始和结尾。输出一个整数，表示需要移除的区间数量。
 * <p>
 * Input: [[1,2], [2,4], [1,3]]
 * <p>
 * Output: 1
 */
public class EraseOverlapIntervals {

    /**
     * 贪心
     * <p>
     * 时间复杂度 O(nlogn)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        // 按照右端点进行增序排序
        // 首个区间就是所有可以选择的区间中右端点最小的那个区间
        Arrays.sort(intervals, (interval1, interval2) -> interval1[1] - interval2[1]);
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度 O(n2)
     */
    public int eraseOverlapIntervalsDp(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        // 按照左端点进行增序排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    @Test
    public void eraseOverlapIntervalsTest() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
        System.out.println(eraseOverlapIntervalsDp(intervals));
    }


}
