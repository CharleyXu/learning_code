package com.xu.algorithm.string;

import com.xu.algorithm.stack.Stack;

/**
 * Created by CharleyXu on 2020-06-11
 * <p>
 * 仅仅反转字母
 */
public class ReverseOnlyLetters {

    /**
     * 字母栈
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stringBuilder.append(stack.pop());
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 反转指针
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters2(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                stringBuilder.append(S.charAt(j--));
            } else {
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

}
