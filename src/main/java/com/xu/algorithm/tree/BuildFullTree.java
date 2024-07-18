package com.xu.algorithm.tree;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/7/16
 * <p>
 * 构建满二叉树
 */
public class BuildFullTree {

    public TreeNode buildFullTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildFullTree(arr, start, mid - 1);
        root.right = buildFullTree(arr, mid + 1, end);
        return root;
    }

    @Test
    public void buildFullTreeTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = buildFullTree(arr, 0, arr.length - 1);
        System.out.println(treeNode.val);
    }


}
