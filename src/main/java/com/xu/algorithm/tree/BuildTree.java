package com.xu.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 从前序和中序遍历序列中构建二叉树
 */
public class BuildTree {

    /**
     * 先序遍历的顺序是根节点，左子树，右子树。
     * <p>
     * 中序遍历的顺序是左子树，根节点，右子树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化哈希表，存储 inorder 元素到索引的映射
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int i, int l, int r) {
        if (r - l < 0) {
            return null;
        }
        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);
        // 查询 m ，从而划分左右子树
        int m = inorderMap.get(preorder[i]);
        // 子问题:构建左子树
        root.left = dfs(preorder, inorderMap, i + 1, l, m - 1);
        // 子问题:构建右子树
        root.right = dfs(preorder, inorderMap, i + 1 + m - l, m + 1, r); // 返回根节点
        return root;
    }

}
