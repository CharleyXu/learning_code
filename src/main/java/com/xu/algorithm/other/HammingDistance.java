package com.xu.algorithm.other;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 461 汉明距离
 * <p>
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * <p>
 * 4   (0 1 0 0)
 * ↑   ↑
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = (x >> i) & 1, b = (y >> i) & 1;
            ans += a ^ b;
        }
        return ans;
    }

    public int hammingDistance2(int x, int y) {
        // 位异或: 第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
        // bitCount 以整数值的二进制补码表示形式返回one-bits的数量计数
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance3(int x, int y) {
        int ans = 0;
        for (int i = x ^ y; i > 0; i -= i & -i) {
            ans++;
        }
        return ans;
    }

    @Test
    public void hammingDistanceTest() {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
        System.out.println(hammingDistance2(x, y));
        System.out.println(hammingDistance3(x, y));
    }

}
