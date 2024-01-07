package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2020-04-30
 * <p>
 * 二叉树的最近公共祖先
 * <p>
 * 所有节点的值都是唯一的
 * <p>
 * p、q 为不同节点且均存在于给定的二叉树中
 */
public class LowestCommonAncestor {

    /**
     * * 1、p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
     * <p>
     * * 2、p q 都在左子树
     * <p>
     * * 3、p q 都在右子树
     * <p>
     * 因为根据定义最近公共祖先节点可以为节点本身
     * <p>
     * 所有节点的值都是唯一的
     * <p>
     * p、q 为不同节点且均存在于给定的二叉树中
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    /**
     * 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        } else {
            return root;
        }
    }

}
