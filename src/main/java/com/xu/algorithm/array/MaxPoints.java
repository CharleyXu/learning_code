package com.xu.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2023/12/11
 * <p>
 * 149 直线上最多的点数
 * <p>
 * 给你一个数组 points ，
 * <p>
 * 其中 points[i] = [Xi, Yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 */
public class MaxPoints {

    /**
     * 斜率 Ay-By/Ax-Bx = By-Cy/Bx-Cx
     * <p>
     * * 避免精度问题
     * <p>
     * Ay-By * Bx-Cx = Ax-Bx * By-Cy
     * <p>
     * 朴素计算 O(n3)
     * 空间复杂度 O(1)
     */
    public int maxPoints(int[][] points) {
        int n = points.length, ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];
                int cnt = 2;
                //枚举点对 (i,j) 并统计有多少点在该线上, 起始 cnt = 2 代表只有 i 和 j 两个点在此线上
                for (int k = j + 1; k < n; k++) {
                    int[] p = points[k];
                    int s1 = (x[1] - y[1]) * (y[0] - p[0]);
                    int s2 = (x[0] - y[0]) * (y[1] - p[1]);
                    if (s1 == s2) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    /**
     * 斜率 Ay-By/Ax-Bx = By-Cy/Bx-Cx
     * <p>
     * * 避免精度问题
     * <p>
     * Ay-By * Bx-Cx = Ax-Bx * By-Cy
     * <p>
     * O(n2 * log m) 其中 n 为点的数量，m 为横纵坐标差的最大值
     * <p>
     * 单次最大公约数计算的时间复杂度是 O(log m)
     */
    public int maxPoints2(int[][] points) {
        int n = points.length, ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                // 求斜率
                String key = a / k + "-" + b / k;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    // 求最大公约数，辗转相除法又称为欧几里得算法
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
