package com.xu.algorithm.array;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2020-06-09
 * <p>
 * 最小差
 */
public class SmallestDifference {

    /**
     * 排序 + 双指针 ，注意类型溢出
     *
     * @param a
     * @param b
     * @return
     */
    public int smallestDifference(int[] a, int[] b) {
        if (a == null || b == null) {
            return 0;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            long diff = a[i] - b[j];
            min = (int) Math.min(Math.abs(diff), min);
            if (diff < 0) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
