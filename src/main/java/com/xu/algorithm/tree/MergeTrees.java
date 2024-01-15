package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2020-04-30
 * <p>
 * 617 合并二叉树
 */
public class MergeTrees {

    /**
     * 创建一个虚拟节点
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = new TreeNode(0);
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        treeNode.val = t1.val + t2.val;
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }

}
