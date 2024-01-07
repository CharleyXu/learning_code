package com.xu.algorithm.greedy;

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
     * 贪心
     * <p>
     * 跳跃的最大长度为 x+nums[x]
     * <p>
     * 依次遍历数组中的每一个元素，实时维护最远可以到达的位置
     * <p>
     * 如果最远可以到达的位置，大于等于数组中的最后一个位置，说明最后一个位置可以到达，直接返回true
     * <p>
     * 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 贪心
     * 返回到达 nums[n - 1] 的最小跳跃次数
     * <p>
     * 跳跃的最大长度为 x+nums[x]
     * <p>
     * 时间复杂度 O(n)，空间复杂度 O(1)
     * <p>
     * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
     * <p>
     * 否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，
     * <p>
     * 我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
