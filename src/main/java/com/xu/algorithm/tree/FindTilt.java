package com.xu.algorithm.tree;

/**
 * Created by CharleyXu on 2020-05-22
 * <p>
 * 给定一个二叉树，计算整个树的坡度
 * <p>
 * <p>
 * 一个树的节点的坡度定义即为，
 * <p>
 * 该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和
 */
public class FindTilt {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        sumTilt(root);
        return sum;
    }

    public int sumTilt(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = sumTilt(root.left);
            int right = sumTilt(root.right);
            sum += Math.abs(left - right);
            return left + right + root.val;
        }
    }

}
