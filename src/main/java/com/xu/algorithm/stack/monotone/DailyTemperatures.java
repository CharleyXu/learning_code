package com.xu.algorithm.stack.monotone;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 739 每日温度
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * <p>
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int pre = deque.pop();
                ans[pre] = i - pre;
            }
            deque.push(i);
        }
        return ans;
    }

    @Test
    public void dailyTemperaturesTest() {
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }

}
