package com.xu.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CharleyXu on 2024/1/12
 * <p>
 * 116 填充每个节点的下一个右侧节点指针
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 */
public class Connect {

    /**
     * 117 填充每个节点的下一个右侧节点指针II
     * <p>
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
     * <p>
     * 层次遍历
     * <p>
     * 时间复杂度 O(n)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i != 1) {
                    last.next = node;
                }
                last = node;
            }
        }
        return root;
    }

    /**
     * 117 填充每个节点的下一个右侧节点指针
     * <p>
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
     * <p>
     * 不使用队列的BFS
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        // cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点。注意这里是访问
            //当前层的节点，然后把下一层的节点串起来
            Node dummy = new Node(0);
            //p表示访下一层节点的前一个节点
            Node p = dummy;
            //遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让p节点
                    //的next指向他，也就是把它串起来
                    p.next = cur.left;
                    //然后再更新p
                    p = p.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    p.next = cur.right;
                    p = p.next;
                }
                //继续访问这样行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }
}
