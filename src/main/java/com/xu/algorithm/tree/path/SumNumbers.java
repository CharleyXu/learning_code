package com.xu.algorithm.tree.path;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.tree.BaseTreeNode;
import com.xu.algorithm.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CharleyXu on 2024/1/12
 * <p>
 * 129 根节点到叶节点的数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 输入：root = [1,2,3]
 * <p>
 * 输出：25
 * <p>
 * 12 + 13  = 25
 */
public class SumNumbers extends BaseLinkedList {

    /**
     * dfs 深度优先搜索
     * <p>
     * 时间复杂度 O（n）
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * bfs层次遍历
     */
    public int sumNumbersBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }

    @Test
    public void sumNumbersTest() {
        System.out.println(sumNumbers(BaseTreeNode.root));
        System.out.println(sumNumbersBfs(BaseTreeNode.root));
    }

}
