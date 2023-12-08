package com.xu.algorithm.structure.tree;

/**
 * Created by CharleyXu on 2023/12/9
 * <p>
 * 100 相同的树
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
