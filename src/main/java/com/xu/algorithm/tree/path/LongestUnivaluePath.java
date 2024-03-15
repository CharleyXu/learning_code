package com.xu.algorithm.tree.path;

import com.xu.algorithm.tree.TreeNode;

/**
 * Created by CharleyXu on 2024/3/15
 * <p>
 * 687. 最长同值路径
 * <p>
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 */
public class LongestUnivaluePath {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curLeft = 0, curRight = 0;
        int maxLeft = dfs(root.left), maxRight = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            curLeft = maxLeft + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            curRight = maxRight + 1;
        }
        max = Math.max(max, curLeft + curRight);
        return Math.max(curLeft, curRight);
    }

}
