package com.xu.algorithm.linkedlist;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by CharleyXu on 2024/1/12
 * <p>
 * 138 随机链表的复制
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * <p>
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
 * <p>
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
public class CopyRandomList {

    Map<Node, Node> nodeMap = new HashMap<>();

    /**
     * <p>
     * 拷贝节点时，当前节点的随机指针指向的节点可能还没创建
     * <p>
     * 对于当前节点，首先要进行拷贝，然后我们进行「当前节点的后继节点」和「当前节点的随机指针指向的节点」拷贝
     * <p>
     * 拷贝完成后将创建的新节点的指针返回，即可完成当前节点的两指针的赋值
     * <p>
     * 回溯 + Hash表
     * <p>
     * 时间复杂度 O(N)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!nodeMap.containsKey(head)) {
            Node headNew = new Node(head.val);
            nodeMap.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return nodeMap.get(head);
    }

    /**
     * 迭代 + 拆分
     * <p>
     * A -> A' -> B -> B'
     *
     * @param head
     * @return
     */
    public Node copyRandomListIterator(Node head) {
        if (head == null) {
            return null;
        }
        // A -> A' -> B -> B'
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        // random指针拷贝
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = node.random != null ? node.random.next : null;
        }
        // 拆分
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = nodeNew.next != null ? nodeNew.next.next : null;
        }
        return headNew;
    }

    @ToString
    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }

}
