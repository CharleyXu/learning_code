package com.xu.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/12/14
 * <p>
 * 402. 移掉 K 位数字
 * <p>
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 */
public class RemoveKdigits {

    /**
     * 贪心 + 单调栈
     * <p>
     * <p>
     * 时间复杂度：O(n)
     * <p>
     * 空间复杂度：O(n)
     * <p>
     * 考虑到栈的特点是后进先出，如果通过栈实现，
     * <p>
     * 则需要将栈内元素依次弹出然后进行翻转才能得到最小数
     * <p>
     * 为了避免翻转操作，可以使用双端队列代替栈的实现
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // 双端队列
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        StringBuilder res = new StringBuilder();
        boolean zero = true;
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (zero && c == '0') {
                continue;
            }
            zero = false;
            res.append(c);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
