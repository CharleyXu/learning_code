package com.xu.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 71 简化路径
 */
public class SimplifyPath {

    /**
     * 时间复杂度 O(N)
     * <p>
     * 空间复杂度 O(N)
     */
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        // 双端队列
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) { // 对于两个点，需要将目录切换到上一级
                if (!stack.isEmpty()) { // 所以只要栈不为空【因为不管如何取上一级，到/根目录也就停了】，就弹出栈顶元素
                    stack.pollLast(); // 弹出栈顶元素
                }
            } else if (name.length() > 0 && !".".equals(name)) { // 不是空字符串或者一个点
                stack.offerLast(name); // 否则就是目录名，直接入栈
            }
        }
        // 全部对last进行poll或者offer就是栈的形式，想想一下
        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty()) {
            builder.append('/');
        } else {
            while (!stack.isEmpty()) {
                builder.append('/').append(stack.pollFirst()); // 先进去的先出来，这样结果才对
            }
        }
        return builder.toString();
    }

}
