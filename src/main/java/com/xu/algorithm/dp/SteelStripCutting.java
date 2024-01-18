package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author CharleyXu Created on 2019/3/27.
 * <p>
 * 钢条切割
 * <p>
 * 长度为 n  价格 Pi   总收益 Rn 最大
 */
public class SteelStripCutting {

    /**
     * 问题状态的定义:在所有可能的两段切割方案中选取组合收益最大值
     *
     * 状态转移方程:  Rn = max(Pi,  R1 + Rn-1，...Rn-1 + R1)
     *
     * q=Math.max(q, p[i-1]+cut(p, n-i))
     */

    /**
     * 朴素递归，回溯法是一样的
     */
    public int cutSteelRecursive(int[] p, int n) {
        if (n < 1) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cutSteelRecursive(p, n - i));
        }
        return q;
    }

    /**
     * DP，自上而下，备忘录
     * <p>
     * q=Math.max(q, p[i-1]+cut(p, n-i))
     */
    public int cutSteel(int[] p, int n) {
        if (n < 1) {
            return 0;
        }
        int[] num = new int[n + 1];
        return cutSteel(p, n, num);
    }

    private int cutSteel(int[] p, int n, int[] num) {
        int q = Integer.MIN_VALUE;
        if (num[n] >= 1) {
            return num[n];
        }
        if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i - 1] + cutSteel(p, n - i));
            }
            num[n] = q;
        }
        return q;
    }

    /**
     * DP，自底向上
     * <p>
     * q=Math.max(q, p[i-1]+cut(p, n-i))
     */
    public int cutSteel2(int[] p, int n) {
        if (n < 1) {
            return 0;
        }
        int[] num = new int[n + 1];
        //长度
        for (int i = 1; i <= n; i++) {
            int q = -1;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j - 1] + num[i - j]);
            }
            num[i] = q;
        }
        return num[n];
    }

    @Test
    public void cutSteelTest() {
        int[] p = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int[] copy = Arrays.copyOf(p, p.length);
        int[] copy2 = Arrays.copyOf(p, p.length);
        int n = 2;
        System.out.println(cutSteelRecursive(p, n));
        System.out.println(cutSteel(copy, n));
        System.out.println(cutSteel2(copy2, n));
    }

}
