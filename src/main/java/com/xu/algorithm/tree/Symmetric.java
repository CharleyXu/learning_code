package com.xu.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CharleyXu Created on 2019/3/22.
 * <p>
 * 对称二叉树，检查它是否是镜像对称
 */
public class Symmetric {

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChildRecursive(root.left, root.right);
    }

    /**
     * 规则：左子树 == 右子树 ,左子树的左子树 == 右子树的右子树
     * <p>
     * 递归
     */
    public boolean isSymmetricChildRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricChildRecursive(left.left, right.right) && isSymmetricChildRecursive(
                left.right,
                right.left);
    }

    /**
     * 迭代
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

}
