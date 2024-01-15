package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 338 比特位计数
 * <p>
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案
 * <p>
 * 输入：n = 2
 * <p>
 * 输出：[0,1,1]
 * <p>
 * 解释：
 * <p>
 * 0 --> 0
 * <p>
 * 1 --> 1
 * <p>
 * 2 --> 10
 */
public class CountBits {


    /**
     * dp
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

}
