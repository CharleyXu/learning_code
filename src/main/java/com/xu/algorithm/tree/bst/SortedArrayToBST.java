package com.xu.algorithm.tree.bst;

import com.xu.algorithm.linkedlist.ListNode;
import com.xu.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 108 将有序数组转换成二叉树
 */
public class SortedArrayToBST {

    /**
     * 108 将有序数组转换成二叉树
     * <p>
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(logn)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + right >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

    /**
     * 109 有序链表转换二叉搜索树
     * <p>
     * 朴素使用额外空间List来记录索引
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }
        return dfsToBST(nodeList, 0, nodeList.size() - 1);
    }

    private TreeNode dfsToBST(List<ListNode> nodeList, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + right >> 1;
        TreeNode root = new TreeNode(nodeList.get(mid).val);
        root.left = dfsToBST(nodeList, left, mid - 1);
        root.right = dfsToBST(nodeList, mid + 1, right);
        return root;
    }

    /**
     * 时间复杂度 O(nlogN)
     * <p>
     * 空间复杂度 O(logn)
     * <p>
     * 分治
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);
        return root;
    }

    /**
     * 分治 时间复杂度的瓶颈在于寻找中位数节点
     * <p>
     * 分治 + 中序遍历优化
     * <p>
     * 中序遍历的顺序是「左子树 - 根节点 - 右子树」
     * <p>
     * 使用一个占位节点，等到中序遍历到该节点时，再填充它的值
     * <p>
     * 时间复杂度 O(n)
     */
    ListNode globalHead;

    public TreeNode sortedListToBST3(ListNode head) {
        if (head == null) {
            return null;
        }
        globalHead = head;
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return buildBST(0, n - 1);
    }

    /**
     * 使用 [l,mid−1] 构建左子树，使用变量 left 保存当前左子树的根节点
     * <p>
     * 构建完左子树后，全局变量 head 必然来到了“中点”位置，用其构建根节点 root，并将根节点与此前构造的 left 关联。同时让链表节点 head 后移
     * <p>
     * 使用 [mid+1,r] 构建右子树，并将其挂载到根节点 root 中
     */
    private TreeNode buildBST(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + r >> 1;
        TreeNode left = buildBST(l, mid - 1);
        TreeNode root = new TreeNode(globalHead.val);
        globalHead = globalHead.next;
        root.left = left;
        root.right = buildBST(mid + 1, r);
        return root;
    }

}
