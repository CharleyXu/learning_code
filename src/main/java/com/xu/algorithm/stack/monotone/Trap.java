package com.xu.algorithm.stack.monotone;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 42 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    //单调递减栈法：按行计算
    // 时间复杂度：O(n)，其中 n 是数组 height 的长度。从 0 到 n−1 的每个下标最多只会入栈和出栈各一次。
    // 空间复杂度：O(n)，其中 n 是数组 height 的长度。空间复杂度主要取决于栈空间，栈的大小不会超过 n
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            //单调递减栈，从左往右遍历，按行计算雨水
            //出现凹槽
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int low = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                //左边比 top 大，右边也比 top 大，形成了下凹，可以积水。
                int L = stack.peek();
                //左边的边界可能比右边大，水量取决于短板
                int shorter = Math.min(height[L], height[i]);
                int distance = i - L - 1;//手动推算即可
                //由于是单调递减栈，栈顶是最小的，越往栈底越大（下标对应的高度）：cur = stack.pop() 出栈顶之后，新栈顶 left > cur
                //凹槽两边的短的那个板减去凹槽
                sum += distance * (shorter - height[low]);
            }
            //存入的是下标，你可以根据下标在 O(1) 时间从数组获取到对应的元素值
            stack.push(i);
        }
        return sum;
    }

}
