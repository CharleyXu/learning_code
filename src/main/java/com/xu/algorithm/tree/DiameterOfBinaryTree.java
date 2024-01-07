package com.xu.algorithm.tree;

import org.junit.Test;

/**
 * Created by CharleyXu on 2020-05-11
 * <p>
 * 二叉树的直径
 */
public class DiameterOfBinaryTree {

    int res = 0;

    /**
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值
     * <p>
     * 这条路径可能穿过也可能不穿过根结点。
     * <p>
     * 二叉树的直径不一定过根节点，因此需要去搜一遍所有子树
     * <p>
     * (例如以root，root.left, root.right...为根节点的树)对应的直径，取最大值
     * <p>
     * root的直径 = root左子树高度 + root右子树高度
     * <p>
     * root的高度 = max {root左子树高度, root右子树高度} + 1
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }

    @Test
    public void getMaxWidthTest() {
        System.out.println(diameterOfBinaryTree(BaseTreeNode.root));
    }
}
