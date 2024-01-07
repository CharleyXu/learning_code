package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2020-04-29
 * <p>
 * 中序 后继
 * <p>
 * 找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）
 */
public class InorderSuccessor {

    /**
     * 二叉搜索树的中序遍历是 递增序列
     * <p>
     * p.val >= root.val  : 进入root 的右子树
     * <p>
     * p.val < root.val  : 进入root 的右子树
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        // 进入root 的右子树
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        // 否则结果有可能是当前节点，或者在当前节点的左子树中
        // 那么先去左子树找一下试试，找不到的话返回当前节点即是结果
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}
