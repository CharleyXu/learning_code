package com.xu.algorithm.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by CharleyXu on 2020-08-13
 */
public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        StringBuilder res = new StringBuilder(root.val + ",");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < d.length; i++) {
            queue.offer(d[i]);
        }
        return pre(queue);
    }

    private TreeNode pre(Queue<String> queue) {
        String val = queue.poll();
        if (Objects.equals(val, "#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
    }

}
