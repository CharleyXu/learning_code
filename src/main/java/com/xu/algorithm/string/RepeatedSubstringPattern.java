package com.xu.algorithm.string;

/**
 * Created by CharleyXu on 2023/12/22
 * <p>
 * 459 重复的子字符串
 * <p>
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * s = "abab"  true
 */
public class RepeatedSubstringPattern {

    /**
     * 1.将原字符串给出拷贝一遍组成新字符串；
     * 2.掐头去尾留中间；
     * 3.如果还包含原字符串，则满足题意
     * <p>
     * <p>
     * 假设字符串有n个子串构成,则拼接后的子串为2n个,掐头去尾后为2n-2个,
     * <p>
     * 如果此时的字符串至少包含一个原字符串,则说明至少包含n个子串,则2n-2>=n,n>=2.
     * <p>
     * 则说明该字符串是周期性结构,最少由两个子串构成.如果一个都不包含,即不包含n个子串,
     * <p>
     * 则说明2n-2<n,n<2,即n为1,也就是不符合周期性结构.
     *
     * abab
     *
     * abababab
     *
     * bababa
     */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    /**
     * O(n2)
     */
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

}
