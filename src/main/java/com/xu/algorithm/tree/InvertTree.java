package com.xu.algorithm.tree;

import com.xu.algorithm.stack.Stack;

/**
 * Created by CharleyXu on 2020-04-30
 * <p>
 * 翻转二叉树
 */
public class InvertTree {

    /**
     * 递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 非递归
     */
    public void invertByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
