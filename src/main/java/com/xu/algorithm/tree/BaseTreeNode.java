package com.xu.algorithm.tree;

/**
 * @author CharleyXu Created on 2019/3/22.
 */
public class BaseTreeNode {

    public static TreeNode root = new TreeNode(50);
    static TreeNode left = new TreeNode(20);
    static TreeNode right = new TreeNode(80);
    static TreeNode left1 = new TreeNode(10);
    static TreeNode right1 = new TreeNode(30);
    static TreeNode left2 = new TreeNode(60);
    static TreeNode right2 = new TreeNode(90);

    static {
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        right.left = left2;
        right.right = right2;
    }

    /**
     *           50
     *      20        80
     *   10    30  60   90
     *
     */

}
