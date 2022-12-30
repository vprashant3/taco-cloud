package com.codingroundpatterns.inplacereversallinkedlist;

import com.codingroundpatterns.LinkedListNode;

public class ReverseBetween {

    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        LinkedListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        LinkedListNode con = prev, tail = cur;

        LinkedListNode third = null;

        while (right > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;


    }
}
