package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.TreeNode;

/**
 * Created by CharleyXu on 2023/11/24
 * <p>
 * 1. 对于根节点，左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值。
 * <p>
 * 2. 任意节点的左、右子树也是二叉搜索树，即同样满足条件 1
 */
public class BinarySearchTree {

    private TreeNode root;

    /* 查找节点 */
    public TreeNode search(int num) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < num) {
                curr = curr.right;
            } else if (curr.val > num) {
                curr = curr.left;
            } else {
                break;
            }
        }
        return curr;
    }

    /* 插入节点 */
    public void insert(int num) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode curr = root, pre = null;
        while (curr != null) {
            if (curr.val == num) {
                return;
            }
            pre = curr;
            if (curr.val < num) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        TreeNode node = new TreeNode(num);
        if (pre.val < num) {
            pre.right = node;
        } else {
            pre.left = node;
        }
    }

    /* 删除节点 */
    public void remove(int num) {
        if (root == null) {
            return;
        }
        // 找到待删除节点和它的父节点
        TreeNode curr = root, pre = null;
        while (curr != null) {
            if (curr.val == num) {
                break;
            }
            pre = curr;
            if (curr.val < num) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (curr == null) {
            return;
        }
        // 子节点数量为 0 or 1
        if (curr.left == null || curr.right == null) {
            TreeNode child = curr.left != null ? curr.left : curr.right;
            // 删除节点curr
            if (curr != root) {
                if (pre.left == curr) {
                    pre.left = child;
                } else {
                    pre.right = child;
                }
            } else {
                root = child;
            }
        } else {
            // 中序遍历有序
            // 二叉树的中序遍历遵循“左 → 根 → 右”的遍历顺序，
            //而二叉搜索树满足“左子节点 < 根 节点 < 右子节点”的大小关系。
            // 中序遍历中 cur 的下一个节点
            TreeNode temp = curr.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            remove(temp.val);
            curr.val = temp.val;
        }
    }

}
