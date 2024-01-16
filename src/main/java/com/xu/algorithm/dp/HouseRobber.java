package com.xu.algorithm.dp;

import com.xu.algorithm.tree.TreeNode;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 打家劫舍
 */
public class HouseRobber {

    /**
     * 198 打家劫舍
     * <p>
     * DP
     * <p>
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     * <p>
     * 输入：[1,2,3,1]
     * <p>
     * 输出：4
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    /**
     * 213 打家劫舍II
     * <p>
     * 所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     * <p>
     * 在不触动警报装置的情况下，今晚能够偷窃到的最高金额。
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob(nums, 2, n - 1), rob(nums, 1, n));
    }

    public int rob(int[] nums, int start, int end) {
        int f0 = 0, f1 = 0;
        for (int i = start; i < end; i++) {
            int value = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = value;
        }
        return f1;
    }

    /**
     * 337 打家劫舍III
     * <p>
     * 所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警
     * <p>
     * f(o) 表示选择o节点的情况下，o节点的子树上被选择的节点的最大权值和。当 o 被选中时，o 的左右孩子都不能被选中
     * <p>
     * g(o) 表示不选择o节点的情况下，o节点的子树上被选择的节点的最大权值和。当 o 未被选中时，o 的左右孩子可以被选中，也可以不被选中
     */
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int selected = root.val + l[1] + r[1];
        int unSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, unSelected};
    }


}
