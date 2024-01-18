package com.xu.algorithm.tree.path;

import com.xu.algorithm.tree.BaseTreeNode;
import com.xu.algorithm.tree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * Created by CharleyXu on 2024/1/7
 * <p>
 * 路径总和
 * <p>
 */
public class PathSum {


    /**
     * 112 路径之和
     * <p>
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSumBst(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            int value = queVal.poll();
            if (node.left == null && node.right == null) {
                if (value == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queNode.offer(node.left);
                queVal.offer(value + node.left.val);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                queVal.offer(value + node.right.val);
            }
        }
        return false;
    }

    /**
     * 113 路径之和
     * <p>
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * <p>
     * 叶子节点 是指没有子节点的节点
     * <p>
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * <p>
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * <p>
     * 回溯，往下减
     */
    public List<List<Integer>> pathSums(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> state, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        // 尝试
        state.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                res.add(new ArrayList<>(state));
            }
            // 回退
            state.remove(state.size() - 1);
            return;
        }
        //  进行下一轮选择
        backtrack(root.left, targetSum - root.val, state, res);
        backtrack(root.right, targetSum - root.val, state, res);
        // 回退
        state.remove(state.size() - 1);
    }

    /**
     * 回溯，往下累加
     */
    public List<List<Integer>> pathSums2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(root, targetSum, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack2(TreeNode root, int targetSum, int total, List<Integer> state, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        // 尝试
        state.add(root.val);
        total += root.val;
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (targetSum == total) {
                res.add(new ArrayList<>(state));
            }
            // 回退
            state.remove(state.size() - 1);
            return;
        }
        //  进行下一轮选择
        backtrack2(root.left, targetSum, total, state, res);
        backtrack2(root.right, targetSum, total, state, res);
        // 回退
        state.remove(state.size() - 1);
    }

    /**
     * BFS
     * <p>
     * 效率差
     */
    public List<List<Integer>> pathSumsBfs(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 使用两个队列，一个存储结点，一个存储从更结点到当前节点的路径
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<List<Integer>> queList = new LinkedList<>();
        queNode.offer(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queList.offer(list);
        while (!queNode.isEmpty()) {
            // 当前节点出队
            TreeNode node = queNode.poll();
            // 当前节点路径出队
            List<Integer> tempList = queList.poll();
            if (node.left == null && node.right == null && node.val == targetSum) {
                res.add(tempList);
            }
            // 左子节点和路径入队
            if (node.left != null) {
                tempList.add(node.left.val);
                queList.add(new ArrayList<>(tempList));
                node.left.val += node.val;
                queNode.add(node.left);
                tempList.remove(tempList.size() - 1);
            }
            // 右子节点和路径入队
            if (node.right != null) {
                tempList.add(node.right.val);
                queList.add(new ArrayList<>(tempList));
                node.right.val += node.val;
                queNode.add(node.right);
            }
        }
        return res;
    }


    @Test
    public void pathSumsTest() {
        System.out.println(pathSums(BaseTreeNode.root, 10));
        System.out.println(pathSums2(BaseTreeNode.root, 10));
        System.out.println(pathSumsBfs(BaseTreeNode.root, 10));
    }

    private boolean dfs(TreeNode root, int val, int targetSum) {
        if (val == targetSum) {
            return true;
        }
        if (root.left != null) {
            return dfs(root.left, val + root.left.val, targetSum);
        }
        if (root.right != null) {
            return dfs(root.right, val + root.right.val, targetSum);
        }
        return false;
    }


    int ans, target;

    /**
     * 437 路径总和
     * <p>
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
     * <p>
     * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 时间复杂度 O(n2)
     */
    public int pathSum(TreeNode root, int targetSum) {
        targetSum = target;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root, root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private void dfs2(TreeNode root, long val) {
        if (val == target) {
            ans++;
        }
        if (root.left != null) {
            dfs2(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, val + root.right.val);
        }
    }

    /**
     * 时间复杂度 O(n)
     * <p>
     * 树的遍历 + 前缀和
     */
    Map<Long, Integer> map = new HashMap<>();
    int ans2, t;

    public int pathSum2(TreeNode root, int _t) {
        if (root == null) return 0;
        t = _t;
        map.put(0L, 1);
        dfs(root, root.val);
        return ans2;
    }

    void dfs(TreeNode root, long val) {
        if (map.containsKey(val - t)) {
            ans2 += map.get(val - t);
        }
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) {
            dfs(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, val + root.right.val);
        }
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}
