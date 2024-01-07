package com.xu.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 452 用最少数量的箭 引爆气球
 * <p>
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * <p>
 * 输出：2
 * <p>
 * 解释：气球可以用2支箭来爆破:
 * <p>
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * <p>
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 */
public class FindMinArrowShots {

    /**
     * 排序 + 贪心
     * <p>
     * 将这支箭的位置移动到它对应的「原本引爆的气球中最靠左的右边界位置」
     */
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        // 按照右端点进行增序排序
        // 首个区间就是所有可以选择的区间中右端点最小的那个区间
        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] > point2[1]) {
                return 1;
            } else if (point1[1] < point2[1]) {
                return -1;
            } else {
                return 0;
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (points[i][0] > pos) {
                pos = points[i][1];
                ans++;
            }
        }
        return ans;
    }


    @Test
    public void findMinArrowShotsTest() {
        int[][] intervals = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] input = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(intervals));
        System.out.println(findMinArrowShots(input));
    }
}
