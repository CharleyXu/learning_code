package com.xu.algorithm.tree;


/**
 * Created by CharleyXu on 2020-04-28
 * <p>
 * 检查平衡性
 * <p>
 * 实现一个函数，检查二叉树是否平衡。
 * <p>
 * 在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //树的深度
    private int depth(TreeNode node) {
        return node == null ? 0 : Math.max(depth(node.left), depth(node.right)) + 1;
    }

}
