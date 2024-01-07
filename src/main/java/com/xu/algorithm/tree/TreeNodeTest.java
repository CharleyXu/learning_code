package com.xu.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2018/3/7.
 */
public class TreeNodeTest {

  /**
   * 二叉树深度(高度)
   */
  public int getMaxDepth(TreeNode root) {
    return root == null ? 0 : Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
  }

  /**
   * 二叉树宽度
   */
  public int getMaxWidth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    //最大宽度
    int maxWidth = 1;
    //入队
    queue.offer(root);
    while (true) {
      //当前层的节点个数
      int len = queue.size();
      if (len == 0) {
        break;
      }
      //如果当前层,还有节点
      while (len > 0) {
        TreeNode treeNode = queue.poll();
        len--;
        //下层节点入队
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        }
        if (treeNode.right != null) {
          queue.add(treeNode.right);
        }
      }
      maxWidth = Math.max(maxWidth, queue.size());
    }
    return maxWidth;
  }

  @Test
  public void getMaxDepthTest() {
    System.out.println(getMaxDepth(BaseTreeNode.root));
  }

  @Test
  public void getMaxWidthTest() {
    System.out.println(getMaxWidth(BaseTreeNode.root));
  }

}
