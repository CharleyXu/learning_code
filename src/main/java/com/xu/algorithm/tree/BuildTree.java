package com.xu.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 105 从前序和中序遍历序列中构建二叉树
 */
public class BuildTree {

    /**
     * 先序遍历的顺序是根节点，左子树，右子树。
     * <p>
     * 中序遍历的顺序是左子树，根节点，右子树
     * <p>
     * 在某一次构建中,前序遍历的第一个元素一定是当前子树的根节点
     * <p>
     * 然后在中序遍历中找到根节点的位置, 左边就是根节点的左子树,右边就是根节点的右子树
     * <p>
     * 然后根据中序遍历得出的左右子树的个数,就可以在前序遍历中找到左右子树的范围,进而找到左右子树的根节点,然后继续递归构建
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化哈希表，存储 inorder 元素到索引的映射
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorderMap, 0, inorder.length - 1, 0);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int preStart, int preEnd, int inorderStart) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        // 初始化根节点
        TreeNode root = new TreeNode(rootVal);
        // 找到根节点的下标
        int rootIdx = inorderMap.get(rootVal);
        // 左节点个数
        int leftCnt = rootIdx - inorderStart;
        // 子问题:构建左子树
        root.left = dfs(preorder, inorderMap, preStart + 1, preStart + leftCnt, inorderStart);
        // 子问题:构建右子树
        root.right = dfs(preorder, inorderMap, preStart + leftCnt + 1, preEnd, rootIdx + 1);
        // 返回根节点
        return root;
    }

}
