package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2023/11/30
 * <p>
 * 124. 二叉树中的最大路径和
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * 时间复杂度：O(N)，其中 N 是二叉树中的节点个数。对每个节点访问不超过 2 次。
     *
     * 空间复杂度：O(N)，空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，最坏情况下，二叉树的高度等于二叉树中的节点个数
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        // 更新答案
        max = Math.max(max, root.val + left + right);
        // 返回节点的最大贡献值
        return root.val + Math.max(left, right);
    }

}
