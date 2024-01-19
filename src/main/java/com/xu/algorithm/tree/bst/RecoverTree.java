package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2024/1/19
 * <p>
 * 99 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树
 */
public class RecoverTree {

    /**
     * 时间复杂度 O(N)
     * <p>
     * 空间复杂度 O(H)，H为二叉搜索树的高度（栈的深度）
     * <p>
     * Morris 中序遍历，可以将空间复杂度降为O(1)
     */
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode x = null, y = null, last = null;
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            //
            if (last != null && root.val < last.val) {
                if (x == null) {
                    x = last;
                }
                y = root;
            }
            last = root;

            root = root.right;
        }
        // swap
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }


}
