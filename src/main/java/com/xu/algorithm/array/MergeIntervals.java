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

    /**
     * 57 插入区间
     * <p>
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
     * <p>
     * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
     * <p>
     * 返回插入之后的 intervals。
     * <p>
     * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                ans.add(interval);
            } else if (interval[0] > newInterval[1]) {
                ans.add(newInterval);
                ans.add(interval);
                newInterval = null;
            } else {
                // 合并区间
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        // 如果合并之后的区间没有保存下来
        if (newInterval != null) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    @Test
    public void mergeIntervalsTest() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    @Test
    public void insertIntervalsTest() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

}
