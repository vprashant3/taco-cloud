package com.codingroundpatterns.inplacereversallinkedlist;


import com.codingroundpatterns.LinkedListNode;

public class ReverseLinkedList {

    public static LinkedListNode reverse(LinkedListNode head) {
       LinkedListNode prev = null;
       LinkedListNode cur = head;
       while (cur != null) {
           LinkedListNode next = head.next;
           head.next = prev;
           prev = head;
           cur = next;
       }
        return prev;
    }
}
