package com.xu.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 135 分发糖果
 * <p>
 * 一群孩子站成一排，每一个孩子有自己的评分。
 * <p>
 * <p>
 * 现在需要给这些孩子发糖果，规则是如果一个孩子的评分比自己身旁的一个孩子要高，
 * <p>
 * 那么这个孩子就必须得到比身旁孩子更多的糖果;所有孩子至少要有一个糖果。
 * <p>
 * 求解最少需要多少个糖果。
 */
public class Candy {

    /**
     * 贪心 + 两次遍历
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] m = new int[n];
        // 初始化
        Arrays.fill(m, 1);
        // 从左向右遍历
        for (int i = 1; i < n; i++) {
            // 右边比左边高
            if (ratings[i] > ratings[i - 1]) {
                m[i] = m[i - 1] + 1;
            }
        }
        // 从右向左遍历
        for (int j = n - 1; j > 0; j--) {
            // 左边比右边高 并且 当前左边孩子的糖果树不大于右边的糖果树
            if (ratings[j - 1] > ratings[j] && m[j - 1] <= m[j]) {
                m[j - 1] = m[j] + 1;
            }
        }
        return Arrays.stream(m).sum();
    }

    @Test
    public void candyTest() {
        int[] ratings = new int[]{1, 0, 2};
        System.out.println(candy(ratings));
    }

}
