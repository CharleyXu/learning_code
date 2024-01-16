package com.xu.algorithm.stack.monotone;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 84 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * <p>
 * 输出：10
 */
public class LargestRectangleArea {

    /**
     * 单调栈
     * <p>
     * <p>
     * 对数组中的每个元素，若假定以它为高，能够展开的宽度越宽，那么以它为高的矩形面积就越大。
     * <p>
     * 因此，思路就是找到每个元素左边第一个比它矮的矩形和右边第一个比它矮的矩形，在这中间的就是最大宽度
     * <p>
     * 最后对每个元素遍历一遍找到最大值即可
     * <p>
     * 头部的0是为了不用判断栈是否为空, 因为题目中都是非负整数, 所以没有数会比0小, 即0一直会在栈底.
     * <p>
     * 尾部的0是为了压出最后已经形成的单调栈的,
     * <p>
     * 比如说示例: 2,1,5,6,2,3遍历完之后单调栈[1,2,3],然后如果没有尾部0, 我们会最后考虑单调栈是否为空,做一个额外的判断,写很多类似的逻辑代码, 加入了尾部0, 就可以把遍历完单调栈[1,2,3]给压出来.
     */
    public int largestRectangleArea(int[] heights) {
        // 初始化最终结果为0
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        // 将给定的原数组左右各添加一个元素0,方便确定原有数组中第一个元素和最后一个元素能不能继续扩张
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        stack.push(0);
        // 开始遍历
        for (int i = 1; i < newHeights.length; i++) {
            // 如果栈不为空且当前考察的元素值小于栈顶元素值，
            // 则表示以栈顶元素值为高的矩形面积可以确定
            while (newHeights[i] < newHeights[stack.peek()]) {
                // 弹出栈顶元素
                int cur = stack.pop();
                // 获取栈顶元素对应的高
                int curHeight = newHeights[cur];
                // 栈顶元素弹出后，新的栈顶元素就是其左侧边界
                int leftIndex = stack.peek();
                // 右侧边界是当前考察的索引
                int rightIndex = i;
                // 计算矩形宽度
                int curWidth = rightIndex - leftIndex - 1;
                // 计算面积
                res = Math.max(res, curWidth * curHeight);
            }
            // 当前考察索引入栈
            stack.push(i);
        }
        return res;
    }

    @Test
    public void largestRectangleAreaTest() {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }

}
