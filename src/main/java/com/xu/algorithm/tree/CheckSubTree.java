package com.xu.algorithm.tree;

import com.xu.algorithm.stack.Stack;

/**
 * Created by CharleyXu on 2020-05-22
 * <p>
 * 检查子树
 * <p>
 * 你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点
 * <p>
 * 设计一个算法，判断 T2 是否为 T1 的子树
 */
public class CheckSubTree {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }
        return isSame(t1, t2) || checkSubTree(t1.left, t2)
                || checkSubTree(t1.right, t2);
    }

    /**
     * 检查相同的树
     */
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }


    /**
     * 非递归前序遍历判断是否相同
     */
    public boolean isSameTreePre(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Stack<TreeNode> stackP = new Stack<>();
        stackP.push(p);
        Stack<TreeNode> stackQ = new Stack<>();
        stackQ.push(q);

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode pNode = stackP.pop();
            TreeNode qNode = stackQ.pop();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null) {
                return false;
            }
            if (pNode.val != qNode.val) {
                return false;
            } else {
                stackP.push(pNode.right);
                stackQ.push(qNode.right);
                stackP.push(pNode.left);
                stackQ.push(qNode.left);
            }
        }
        return true;

    }
}
