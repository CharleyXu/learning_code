package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 173 二叉搜索树的迭代器
 */
public class BSTIterator {

    private int idx;

    private List<Integer> list;

    public BSTIterator(TreeNode treeNode) {
        idx = 0;
        list = new ArrayList<>();
        inorderTraversal(treeNode, list);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private void inorderTraversal2(TreeNode root, List<Integer> list) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    class BSTIterator2 {

        Deque<TreeNode> d = new ArrayDeque<>();

        public BSTIterator2(TreeNode root) {
            // 步骤 1
            dfsLeft(root);
        }

        public int next() {
            // 步骤 2
            TreeNode root = d.pop();
            int ans = root.val;
            // 步骤 3
            root = root.right;
            // 步骤 1
            dfsLeft(root);
            return ans;
        }

        void dfsLeft(TreeNode root) {
            while (root != null) {
                d.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !d.isEmpty();
        }

    }

}
