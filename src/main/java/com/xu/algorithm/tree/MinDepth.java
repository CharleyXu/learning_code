package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2023/11/30
 * <p>
 * 二叉树的最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
    }

    /**
     * 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m1 = maxDepth(root.left);
        int m2 = maxDepth(root.right);
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.max(m1, m2) + 1;
    }

}
