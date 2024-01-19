package com.xu.algorithm.tree.bst;

import com.xu.algorithm.tree.BaseTreeNode;
import com.xu.algorithm.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2020-06-02
 * <p>
 * 230 二叉搜索树中第K小的元素
 */
public class KthSmallest extends BaseTreeNode {

    /**
     * 中序遍历 (单调递增)
     * <p>
     * 二叉搜索树的性质：对于树中的任意非叶子节点 node，
     * <p>
     * 它的左子树的所有节点的值都小于 node.val，
     * <p>
     * 且它的右子树的所有节点的值都大于 node.val
     * <p>
     * 时间复杂度：令 h 为树高，先到达叶子位置（最小节点位置），复杂度为 O(h)
     * <p>
     * 然后找到第 k 小的元素，复杂度为 O(k)。整体复杂度为 O(h+k)
     * 空间复杂度：令 h 为树高，复杂度为 O(h)
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    /**
     * 50
     * 20        80
     * 10    30  60   90
     */
    @Test
    public void kthSmallestTest() {
        System.out.println(kthSmallest(root, 6));
    }

}
