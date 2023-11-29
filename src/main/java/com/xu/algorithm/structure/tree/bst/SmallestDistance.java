package com.xu.algorithm.structure.tree.bst;

import com.xu.algorithm.structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 二叉搜索树节点最小距离
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
}
