package com.xu.algorithm.structure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author CharleyXu Created on 2019/3/22.
 */
@AllArgsConstructor
@ToString
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

}
