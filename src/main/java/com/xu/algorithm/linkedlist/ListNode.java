package com.xu.algorithm.linkedlist;

import lombok.ToString;

/**
 * @author CharleyXu Created on 2019/3/22.
 */
@ToString
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
