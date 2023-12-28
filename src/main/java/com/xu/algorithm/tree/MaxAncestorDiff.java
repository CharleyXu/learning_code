package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2020-05-06
 * <p>
 * 节点与其祖先之间的最大差值
 */
public class MaxAncestorDiff {

    private int result = Integer.MIN_VALUE;

    /**
     * dfs一条条路径下去即可，
     * <p>
     * 在遍历时需要记录当前路径（不包括当前节点，因为当前节点减自己是0）的最大和最小值
     * <p>
     */
    public int maxAncestorDiff(TreeNode root) {
        find(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result;
    }

    private void find(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        int maxValue = Math.max(max, root.val);
        int minValue = Math.min(min, root.val);
        result = Math.max(result, Math.max(Math.abs(maxValue - root.val), Math.abs(root.val - minValue)));
        find(root.left, maxValue, minValue);
        find(root.right, maxValue, minValue);
    }


    public int maxAncestorDiff2(TreeNode root) {
        int left = maxAncestorDiff(root.left, root.val, root.val);
        int right = maxAncestorDiff(root.right, root.val, root.val);
        return left > right ? left : right;
    }

    public int maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        if (root.val > max) {
            max = root.val;
        } else if (root.val < min) {
            min = root.val;
        }
        if (root.left == null && root.right == null) {
            return max - min;
        }
        int left = maxAncestorDiff(root.left, max, min);
        int right = maxAncestorDiff(root.right, max, min);
        return left > right ? left : right;
    }

}
