package com.xu.algorithm.greedy;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 605 种花问题
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

}
