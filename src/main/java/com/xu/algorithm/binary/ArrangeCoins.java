package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-17
 * <p>
 * 排列硬币
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    //  二分查找，O(log(n / 2 + 1))
    public static int arrangeCoins3(int n) {
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (mid * (mid + 1) >> 1 <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }

    @Test
    public void arrangeCoinsTest() {
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins3(8));
    }

}
