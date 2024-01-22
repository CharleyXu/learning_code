package com.xu.algorithm.linkedlist;

/**
 * Created by CharleyXu on 2024/1/19
 * <p>
 * 725 分隔链表
 * <p>
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * <p>
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 */
public class SplitListToParts {

    /**
     * 时间复杂度 O(N)
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode cnt = head;
        while (cnt != null) {
            n++;
            cnt = cnt.next;
        }
        int q = n / k, r = n % k;
        ListNode[] parts = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            parts[i] = cur;
            int partSize = q + (i < r ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return parts;
    }

}
