package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2023/12/20
 * <p>
 * 55 跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * nums = [2,3,1,1,4]
 * <p>
 * true
 * <p>
 * nums = [3,2,1,0,4]
 * <p>
 * false
 */
public class CanJump {

    /**
     * dp[i]:从[0,i]的任意一点出发，最大可跳跃的位置
     * <p>
     * dp[i] = max(dp[i-1],nums[i] + i);
     * <p>
     * 判断是否可以到最后一位
     * <p>
     * 当棋子到下标i，最多只能到下标i，dp[i] == i 原地踏步无法前进
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (dp[i] >= nums.length - 1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1696 跳跃游戏VI
     * <p>
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * <p>
     * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
     * <p>
     * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的得分为经过的所有数字之和。
     * <p>
     * 请你返回你能得到的最大得分 。
     * <p>
     * <p>
     * 输入：nums = [1,-1,-2,4,-7,3], k = 2
     * <p>
     * 输出：7
     * <p>
     * 解释：你可以选择子序列 [1,-1,4,3] ，和为 7
     * <p>
     * dp[i] = max(dp[i-t]) + nums[i], t=[1, k]
     * <p>
     * DP + 优先级队列
     * <p>
     * 时间复杂度 O(nlogn)
     */
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        // 优先队列维护 计算过的状态值和对应下标
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.offer(new int[]{dp[0], 0});
        for (int i = 1; i < n; i++) {
            while (priorityQueue.peek()[1] < i - k) {
                priorityQueue.poll();
            }
            dp[i] = priorityQueue.peek()[0] + nums[i];
            priorityQueue.offer(new int[]{dp[i], i});
        }
        return dp[n - 1];
    }

    /**
     * 1696 跳跃游戏VI
     * <p>
     * DP + 单调队列
     * <p>
     * 时间复杂度 O(n)
     */
    public int maxResultDeque(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (queue.getFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = nums[i] + dp[queue.getFirst()];
            // 单调递减队列
            while (!queue.isEmpty() && dp[queue.getLast()] < dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n - 1];
    }

    @Test
    public void maxResultTest() {
        int[] nums = new int[]{1, -1, -2, 4, -7, 3};
        System.out.println(maxResult(nums, 2));
        System.out.println(maxResultDeque(nums, 2));
    }

}
