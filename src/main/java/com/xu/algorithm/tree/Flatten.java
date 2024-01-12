package com.xu.algorithm.tree;

import com.xu.algorithm.stack.Stack;

/**
 * Created by CharleyXu on 2024/1/12
 * <p>
 * 114 二叉树展开为链表
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null
 * <p>
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 */
public class Flatten {

    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            if (pre != null) {
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
            pre = temp;
        }
    }

}
