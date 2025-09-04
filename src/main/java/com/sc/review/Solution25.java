package com.sc.review;

import com.sc.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        p = dummy;
        while (count >= k) {
            count -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            ListNode next = p.next;
            next.next = curr;
            p.next = pre;
            p = next;

        }
        return dummy.next;
    }
}
