package com.xu.algorithm.tree.traversal;

import com.xu.algorithm.stack.Stack;
import com.xu.algorithm.tree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author CharleyXu Created on 2019/3/25.
 * <p>
 * 二叉树遍历
 */
public class Traversal {

    /**
     * 前序遍历
     * <p>
     * 根-左子树-右子树
     */
    public void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 前序遍历,非递归(DFS) Depth-First-Search 深度优先
     * <p>
     * 从初始点开始按照一个方向遍历，这个方向到尽头停止后到另一个方向，直到所有操作完成退出
     * <p>
     * 根-左子树-右子树
     */
    public List<Integer> preOrder(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(head);
        while (!treeNodeStack.isEmpty()) {
            TreeNode treeNode = treeNodeStack.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) {
                treeNodeStack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                treeNodeStack.push(treeNode.left);
            }
        }
        return res;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            root = root.right;
        }
        return res;
    }

    /**
     * 中序遍历
     * 左子树-根-右子树
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * Morris中序遍历
     * <p>
     * 非递归的中序遍历空间复杂度降为 O(1)
     */
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前root节点向左走一步，一直向右走直至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让predecessor 右指针指向root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 左子树访问完了，断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
                // 如果没有子孩子，直接访问右孩子
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 中序遍历
     * <p>
     * 左子树-根-右子树
     */
    public void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.val);
        inOrderRecur(head.right);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        traversal(nodeList, root);
        return nodeList;
    }

    private void traversal(List<Integer> nodeList, TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(nodeList, root.left);
        traversal(nodeList, root.right);
        nodeList.add(root.val);
    }

    /**
     * 后序遍历
     * <p>
     * 左子树-右子树-根
     */
    public void postOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.val);
    }

    /**
     * 两个栈实现后序遍历
     * <p>
     * 左子树-右子树-根
     * <p>
     * 两个栈实现
     * <p>
     * 1、申请两个栈s1，s2，头节点入栈s1
     * <p>
     * 2、如果栈s1不为空，执行以下操作：弹出一个元素，入栈s2，
     * <p>
     * 如果该节点左孩子(右孩子)不空入栈s1.
     * <p>
     * 3、将栈s2中的节点一次出栈，打印。
     */
    public void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
        }
        while (!s2.isEmpty()) {
            TreeNode cur = s2.pop();
            System.out.println(cur.val);
        }
    }

    /**
     * 层次遍历
     * <p>
     * 使用队列
     * <p>
     * 广度优先搜索算法（Breadth-First-Search，缩写为 BFS），是一种利用队列实现的搜索算法
     * <p>
     * <p>
     * 其中俩个思想：
     * <p>
     * 1. 队列不为空则循环
     * <p>
     * 2. 将未访问的邻接点压入队列后面，然后从前面取出并访问（这样就做到了广度优先）
     */
    public void levelTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(head);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                treeNodes.offer(node.left);
            }
            if (node.right != null) {
                treeNodes.offer(node.right);
            }
        }
    }

    /**
     * 102 二叉树的层次遍历
     * <p>
     * 使用队列 + 判断队列 size()，逐个count--;
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int count = nodes.size();
            List<Integer> intList = new ArrayList<>();
            while (count > 0) {
                TreeNode node = nodes.poll();
                intList.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
                count--;
            }
            list.add(intList);
        }
        return list;
    }

    /**
     * 103 二叉树的锯齿形层序遍历
     * <p>
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (count > 0) {
                TreeNode treeNode = queue.poll();
                if (flag) {
                    integers.add(0, treeNode.val);
                } else {
                    integers.add(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                count--;
            }
            ans.add(integers);
            flag = !flag;
        }
        return ans;
    }


    /**
     * 107 二叉树的层序遍历，自底向上的层序遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (count > 0) {
                TreeNode treeNode = queue.poll();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                count--;
            }
            res.add(0, integers);
        }
        return res;
    }

    @Test
    public void preOrder() {
        System.out.println(preOrder(BaseTree.root));
        System.out.println(preOrderTraversal(BaseTree.root));
    }

    @Test
    public void inOrder() {
        inOrderRecur(BaseTree.root);
        System.out.println(inorderTraversal(BaseTree.root));
        System.out.println(inorderTraversalMorris(BaseTree.root));
    }

    @Test
    public void postOrder() {
        postOrder(BaseTree.root);
    }

    @Test
    public void preOrderRecurTest() {
        preOrderRecur(BaseTree.root);
    }

    @Test
    public void inOrderRecurTest() {
        inOrderRecur(BaseTree.root);
    }

    @Test
    public void postOrderRecurTest() {
        postOrderRecur(BaseTree.root);
    }

    @Test
    public void levelTraverseTest() {
        levelTraverse(BaseTree.root);
    }

    @Test
    public void levelOrderTest() {
        System.out.println(levelOrder(BaseTree.root));
    }

}
