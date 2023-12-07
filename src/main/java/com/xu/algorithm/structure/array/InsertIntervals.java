package com.xu.algorithm.structure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2023/12/6
 * <p>
 * 57. 插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class InsertIntervals {

    /**
     * 时间复杂度：O(n)，其中 n 是数组 intervals 的长度，即给定的区间个数。
     * <p>
     * 空间复杂度：O(1)。除了存储返回答案的空间以外，我们只需要额外的常数空间即可
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // 左侧区间
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        // 重叠区间
        while (i < n && intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        // 右侧区间
        while (i < n && intervals[i][0] > newInterval[1]) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

}
