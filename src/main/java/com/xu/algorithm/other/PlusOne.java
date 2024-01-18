package com.xu.algorithm.other;

/**
 * Created by CharleyXu on 2024/1/18
 * <p>
 * 66 加一
 *
 * <p>
 * 输入：digits = [1,2,3]
 * <p>
 * 输出：[1,2,4]
 */
public class PlusOne {

    /**
     * 判断加1之后是不是0
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }

}
