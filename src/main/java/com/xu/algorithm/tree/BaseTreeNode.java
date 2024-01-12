package com.xu.algorithm.tree;

/**
 * @author CharleyXu Created on 2019/3/22.
 */
public class BaseTreeNode {

    public static TreeNode root = new TreeNode(5);
    static TreeNode left = new TreeNode(2);
    static TreeNode right = new TreeNode(8);
    static TreeNode left1 = new TreeNode(1);
    static TreeNode right1 = new TreeNode(3);
    static TreeNode left2 = new TreeNode(6);
    static TreeNode right2 = new TreeNode(9);

    static {
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        right.left = left2;
        right.right = right2;
    }

    /**
     *           5
     *      2      8
     *    1    3  6   9
     *
     */

}
