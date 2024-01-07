package com.xu.algorithm.tree;

import org.junit.Test;

/**
 * Created by CharleyXu on 2020-08-13
 * <p>
 * 完全二叉树的节点个数
 */
public class CountNodes extends BaseTreeNode {

    /**
     * 节点个数（普适）
     *
     * @param root
     * @return
     */
    public int countNodesSimple(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    /**
     * 完全二叉树的节点数量肯定最多2^k-1
     * <p>
     * 完全二叉树中，除了最后一层外，其余每层节点都是满的，并且最后一层的节点全部靠向左边。
     */
    // Return tree depth in O(d) time.
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    /**
     * 二分查找
     *
     * @param root
     * @return
     */
    public int countNodesBinary(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int) Math.pow(2, d) - 1 + left;
    }

    /**
     * 层数
     *
     * @param root
     * @return
     */
    private int countLevel(TreeNode root) {
        return root == null ? 0 : Math.max(countLevel(root.left), countLevel(root.right)) + 1;
    }

    @Test
    public void countNNodeBinaryTest() {
        System.out.println(countNodesBinary(root));
        System.out.println(countNodes(root));
    }

}
