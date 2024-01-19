package com.xu.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author CharleyXu Created on 2019/3/22.
 */
@AllArgsConstructor
@ToString
public class TreeNode {

    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

}
