package com.xu.algorithm.tree.path;

import com.xu.algorithm.tree.TreeNode;

/**
 * Created by CharleyXu on 2024/1/29
 * <p>
 * 1457 二叉树中的伪回文路径
 * <p>
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目
 * <p>
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 * <p>
 * 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1]
 * <p>
 * 1 <= Node.val <= 9
 */
public class PseudoPalindromicPaths {

    /**
     * dfs
     * <p>
     * 长度为偶数，即出现次数为奇数的字符个数为0个
     * <p>
     * 长度为奇数，即出现次数为奇数的字符个数为1个（位于中间）
     * <p>
     * 时间复杂度：O(C×n)，C是不同元素的数量，n是二叉树节点数
     * <p>
     * 空间复杂度 O(N)
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] counter = new int[10];
        return dfs(root, counter);
    }

    private int dfs(TreeNode root, int[] counter) {
        if (root == null) {
            return 0;
        }
        // 修改 node.val 出现次数的奇偶性。如果对应位相同则结果为0，如果对应位不同则结果为1
        counter[root.val] ^= 1;
        int res = 0;
        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(counter)) {
                res = 1;
            }
        } else {
            res = dfs(root.left, counter) + dfs(root.right, counter);
        }
        counter[root.val] ^= 1;
        return res;
    }

    private boolean isPseudoPalindromic(int[] counter) {
        int cnt = 0;
        for (int value : counter) {
            cnt += value;
        }
        return cnt <= 1;
    }


    int ans = 0;

    /**
     * 翻转一个二进制数字中的某一位可使用「异或」操作，具体操作位 cnt ^= 1 << k
     * <p>
     * 时间复杂度 O(N)
     * <p>
     * 空间复杂度 O(logN)
     */
    public int pseudoPalindromicPaths2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int cnt) {
        if (root.left == null && root.right == null) {
            cnt ^= 1 << root.val;
            if (cnt == (cnt & -cnt)) ans++;
            return;
        }
        if (root.left != null) {
            dfs(root.left, cnt ^ (1 << root.val));
        }
        if (root.right != null) {
            dfs(root.right, cnt ^ (1 << root.val));
        }
    }
}
