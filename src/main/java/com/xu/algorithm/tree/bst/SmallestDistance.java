package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 783
 * <p>
 * 二叉搜索树节点最小距离
 * <p>
 * 返回树中任意两个不同节点值之间的最小差值
 */
public class SmallestDistance {

    int ans = Integer.MAX_VALUE;
    int pre = -1;

    public int minDiffInBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            updateVal(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    private void updateVal(int val) {
        if (pre >= 0) {
            ans = Math.min(ans, val - pre);
        }
        pre = val;
    }

    public int minDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        updateVal(root.val);
        dfs(root.right);
    }


}
