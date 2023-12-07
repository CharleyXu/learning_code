package com.xu.algorithm.structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    public int[][] merge(int[][] intervals) {
        // 先按照区间左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
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
        // 时间复杂度是排序的时间复杂度 O(nlogn)
        // 空间复杂度是排序的空间负责度 O(logn)
        return list.toArray(new int[list.size()][]);
    }

}
