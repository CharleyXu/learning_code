package com.xu.algorithm.binary;

import org.junit.Test;

import java.text.NumberFormat;

/**
 * Created by CharleyXu on 2020-08-10
 * <p>
 * 69 求X的平方根
 *
 * <p>
 * 求平方根，结果精确到0.01
 */
public class Sqrts {

    /**
     * 二分查找，O(logx)
     */
    private int simpleSqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        int left = 0;
        int right = x / 2;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * 牛顿迭代法，O(logx)
     * <p>
     * 公式为 x n+1 = x n − f (x n)/ f ′(x n)
     */
    private int sqrt2(int x) {
        long m = x;
        while (m * m > x) {
            m = (m + x / m) / 2;
        }
        return (int) m;
    }

    private String sqrt(float x) {
        float left = 0, right = x, ans = -1;
        while (left <= right) {
            float mid = (left + right) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 0.1f;
            } else {
                right = mid - 0.1f;
            }
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        numberInstance.setGroupingUsed(false);
        return numberInstance.format(ans);
    }

    @Test
    public void sqrtTest() {
        System.out.println(sqrt(21.332f));
        System.out.println(sqrt(481.332f));
        System.out.println(simpleSqrt(84));
    }


}
