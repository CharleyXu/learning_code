package com.xu.algorithm.other;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/18
 * <p>
 * 29 两数相除
 * <p>
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * <p>
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2，
 * <p>
 * 返回商
 * <p>
 * 输入: dividend = 10, divisor = 3
 * <p>
 * 输出: 3
 * <p>
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3
 */
public class Divide {

    /**
     * 时间复杂度 O(logn)
     */
    public int divide(int dividend, int divisor) {
        long result;
        long x = dividend;
        long y = divisor;
        boolean negative = (x < 0 && y > 0) || (x > 0 && y < 0);
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        // 结果在【0，x】范围内，二分
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (quickMulti(mid, y) <= x) {
                // 结果不大于x，左指针右移
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result = negative ? -left : left;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    /**
     * 快速乘法
     * <p>
     * 倍增
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 积
     */
    private long quickMulti(long a, long b) {
        long result = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                // 当前最低位为1，结果里加上a
                result += a;
            }
            // 被乘数右移1位，相当于除以2
            b >>= 1;
            // 乘数倍增，相当于乘以2
            a += a;
        }
        return result;
    }

    @Test
    public void divideTest() {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
    }

}
