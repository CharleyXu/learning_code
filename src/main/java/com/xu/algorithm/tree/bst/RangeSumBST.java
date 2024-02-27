package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.TreeNode;

/**
 * Created by CharleyXu on 2024/2/27
 * <p>
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (root.val < high) {
            res += rangeSumBST2(root.right, low, high);
        }
        if (root.val > low) {
            res += rangeSumBST2(root.left, low, high);
        }
        return res;
    }

}
