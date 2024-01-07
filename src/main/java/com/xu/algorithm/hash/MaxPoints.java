package com.xu.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2024/1/5
 * <p>
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 */
public class MaxPoints {

    public int maxPoints(int[][] points) {
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
