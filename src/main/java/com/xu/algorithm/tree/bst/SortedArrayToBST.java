package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.TreeNode;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 108 将有序数组转换成二叉树
 */
public class SortedArrayToBST {

    /**
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(logn)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + right >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

}
