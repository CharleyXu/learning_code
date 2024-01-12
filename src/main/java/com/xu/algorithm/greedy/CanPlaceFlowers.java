package com.xu.algorithm.greedy;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 605 种花问题
 * <p>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * <p>
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * <p>
 * 输出：true
 */
public class CanPlaceFlowers {

    /**
     * 贪心
     * <p>
     * 固定大小为3的窗口，l左边界，r 右边界，花种在中间
     * <p>
     * 当遇到1时，l追上r. 当能种植新花时l = l + 2;
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length, left = -1, right = 0;
        while (right <= length) {
            int value = right == length ? 0 : flowerbed[right];
            right++;
            if (value == 1) {
                left = right;
            }
            if (right - left == 3) {
                n--;
                left += 2;
            }
        }
        return n <= 0;
    }

    /**
     * 时间复杂度 O(n)
     * <p>
     * 需要 flowerbed[i - 1],flowerbed[i],flowerbed[i + 1] 均为0
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && (i == m - 1 || flowerbed[i + 1] == 0)) {
                n--;
                i++; // 下一个位置不能种花，直接跳过
            }
        }
        return n <= 0;
    }

    @Test
    public void placeFlowersTest() {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));
        System.out.println(canPlaceFlowers2(flowerbed, 1));
    }

}
