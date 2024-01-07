package com.xu.algorithm.tree.traversal;


import com.xu.algorithm.tree.TreeNode;

/**
 * @author CharleyXu Created on 2019/3/25.
 */
public class BaseTree {

  /**
   *
   *          0
   *      1       2
   *    3   4   5   6
   */

  public static TreeNode root = new TreeNode(0);
  public static TreeNode left = new TreeNode(1);
  public static TreeNode right = new TreeNode(2);
  public static TreeNode left1 = new TreeNode(3);
  public static TreeNode right1 = new TreeNode(4);
  public static TreeNode left2 = new TreeNode(5);
  public static TreeNode right2 = new TreeNode(6);

  static {
    root.left = left;
    root.right = right;
    left.left = left1;
    left.right = right1;
    right.left = left2;
    right.right = right2;
  }

}
