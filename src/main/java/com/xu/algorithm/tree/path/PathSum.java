package com.xu.algorithm.tree.path;

import com.xu.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2024/1/7
 * <p>
 * 437 路径总和
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * <p>
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 */
public class PathSum {

    int ans, target;

    /**
     * 时间复杂度 O(n2)
     */
    public int pathSum(TreeNode root, int targetSum) {
        targetSum = target;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root, root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private void dfs2(TreeNode root, long val) {
        if (val == target) {
            ans++;
        }
        if (root.left != null) {
            dfs2(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, val + root.right.val);
        }
    }

    /**
     * 时间复杂度 O(n)
     * <p>
     * 树的遍历 + 前缀和
     */
    Map<Long, Integer> map = new HashMap<>();
    int ans2, t;

    public int pathSum2(TreeNode root, int _t) {
        if (root == null) return 0;
        t = _t;
        map.put(0L, 1);
        dfs(root, root.val);
        return ans2;
    }

    void dfs(TreeNode root, long val) {
        if (map.containsKey(val - t)) {
            ans2 += map.get(val - t);
        }
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) {
            dfs(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, val + root.right.val);
        }
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}
