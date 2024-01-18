package com.xu.algorithm.string;

/**
 * Created by CharleyXu on 2024/1/18
 * <p>
 * 65  有效数字
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * <p>
 * 至少一位数字
 * <p>
 * 部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * <p>
 * 部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * <p>
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true
 */
public class IsNumber {

    public boolean isNumber(String s) {
        // 数字标识，点标识，e标识
        boolean numFlag = false, dotFlag = false, eFlag = false;
        for (int i = 0; i < s.length(); ++i) {
            // 数字标识为true
            if (Character.isDigit(s.charAt(i))) {
                numFlag = true;
            }
            // s[i]为'.'，需要点未出现过且e未出现过
            else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            }
            // s[i]为e，需要e未出现过且之前有数字
            else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false; // 出现e之后重新判断整数
            }
            // s[i]为+-，只能出现在首位或者e之后
            else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E'))) {
                continue;
            }
            // 其他情况非法
            else {
                return false;
            }
        }
        // 避免'.'这种测试样例，保证出现数字
        return numFlag;
    }

}
