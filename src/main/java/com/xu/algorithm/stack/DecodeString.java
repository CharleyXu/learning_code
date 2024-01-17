package com.xu.algorithm.stack;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 394 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
 * <p>
 * <p>
 * 输入：s = "3[a]2[bc]"
 * <p>
 * 输出："aaabcbc"
 * <p>
 * <p>
 * 输入：s = "3[a2[c]]"
 * <p>
 * 输出："accaccacc"
 */
public class DecodeString {

    /**
     * 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
     * <p>
     * 如果当前的字符为字母或者左括号，直接进栈
     * <p>
     * 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，
     * <p>
     * 此时取出栈顶的数字（此时栈顶一定是数字），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
     */
    public String decodeString(String s) {
        int n = s.length();
        int ptr = 0;
        LinkedList<String> deque = new LinkedList<>();
        while (ptr < n) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取数字并进栈
                StringBuilder digit = new StringBuilder();
                while (Character.isDigit(s.charAt(ptr))) {
                    digit.append(s.charAt(ptr++));
                }
                deque.addLast(digit.toString());
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取字母入栈
                deque.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(deque.peekLast())) {
                    sub.addLast(deque.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                deque.removeLast();
                // 次数
                int times = Integer.parseInt(deque.removeLast());
                StringBuilder t = new StringBuilder();
                String subString = getString(sub);
                while (times-- > 0) {
                    t.append(subString);
                }
                // 将构造好的字符串入栈
                deque.addLast(t.toString());
            }
        }
        return getString(deque);
    }

    /**
     * 辅助栈法
     */
    public String decodeString2(String s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        LinkedList<Integer> kStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = c - '0' + k * 10;
            } else if (c == '[') {
                //碰到括号，记录K和当前res，归零
                kStack.addLast(k);
                resStack.addLast(res.toString());
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 出最近的一个左括号入的cur, 当前res进行计算不入栈
                int curK = kStack.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < curK; i++) {
                    tmp.append(res);
                }
                // 与括号外合并
                res = new StringBuilder(resStack.removeLast() + tmp);
            } else {
                // 如果是字母则缓慢添加
                res.append(c);
            }
        }
        return res.toString();
    }


    private String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    @Test
    public void decodeStringTest() {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
        System.out.println(decodeString2(str));
    }

}
