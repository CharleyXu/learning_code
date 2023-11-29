package com.xu.algorithm.structure.tree.bst;


import com.xu.algorithm.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2020-04-28
 * <p>
 * 合法二叉搜索树  Binary Search Tree
 * <p>
 * 二叉搜索树定义
 * <p>
 * 任意一个节点 n，
 * <p>
 * 其左子树（left subtree）下的每个后代节点（descendant node）的值都小于 节点 n 的值；
 * <p>
 * 其右子树（right subtree）下的每个后代节点的值都大于节点 n 的值
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 方法一

    // 二叉搜索树的性质：对于树中的任意非叶子节点 node，
    //
    // 它的左子树的所有节点的值都小于 node.val，
    //
    // 且它的右子树的所有节点的值都大于 node.val

    // 用 long 来存储允许的最小值和最大值
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // 方法二
    // 中序遍历 + 单调递增
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        // 判断 单调递增集合
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // 中序遍历
    public void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }
}
