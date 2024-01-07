package com.xu.algorithm.dp;

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
}
