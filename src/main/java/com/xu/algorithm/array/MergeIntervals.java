package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2023/12/6
 * <p>
 * 56. 合并空间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，
 * <p>
 * 其中单个区间为 intervals[i] = [start, end] 。
 * <p>
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 */
public class MergeIntervals {

    /**
     * 时间复杂度 O(nlogn)
     */
    public int[][] merge(int[][] intervals) {
        // 按照区间左端点排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] pre = list.get(list.size() - 1);
            //
            if (interval[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], interval[1]);
            } else {
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void mergeIntervalsTest() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

}
