package com.xu.algorithm.string;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 43 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * <p>
 * 输出: "6"
 */
public class Multiply {

    /**
     * 时间复杂度：O∗(∗MN∗)。M,N 分别为 num1 和 num2 的长度
     * <p>
     * 空间复杂度：O∗(M+N)。用于存储计算结果。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    @Test
    public void multiplyTest() {
        String num1 = "123";
        String num2 = "45";
        System.out.println(multiply(num1, num2));
    }

}
