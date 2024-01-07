package com.xu.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CharleyXu on 2020-06-18
 * <p>
 * 寻找重复的子树
 */
public class FindDuplicateSubtrees extends BaseTreeNode {


    /**
     * 唯一标识符
     * <p>
     * 假设每棵子树都有一个唯一标识符：只有当两个子树的 id 相同时，认为这两个子树是相同的
     */
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x -> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        return uid;
    }

    @Test
    public void findDuplicateSubTreeTest() {
        System.out.println(findDuplicateSubtrees(root));
    }

}
