package com.xu.algorithm.other;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 50. Pow
 * <p>
 * 计算 x 的整数 n 次幂函数（即，xn ）
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class MyPow {

    /**
     * 时间复杂度 log n
     */
    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    @Test
    public void powTest() {
        double x = 2.100;
        int n = 3;
        System.out.println(myPow(x, n));
    }

}
