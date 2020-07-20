package com.LeetCode.July;

import com.LeetCode.HelperClasses.ListNode;

public class Day20_RemoveLinkedListElements {

    // recursive
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return  null;
        if(head.val == val) {
            head = removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
        }
        return head;
    }

    // first pass iterative soln
    public ListNode removeElementsIterative(ListNode head, int val) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode prev =  null;

        while(cur != null) {
            if(cur.val == val) {
                if(prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
