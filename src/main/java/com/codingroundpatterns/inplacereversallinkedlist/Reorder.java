package com.codingroundpatterns.inplacereversallinkedlist;

import com.codingroundpatterns.LinkedListNode;

import static com.codingroundpatterns.Utils.findMid;
import static com.codingroundpatterns.Utils.reverseLinkedList;

public class Reorder {

    public static LinkedListNode reorderList(LinkedListNode head) {
        LinkedListNode mid = findMid(head);
        LinkedListNode reveredLinkedListHead = reverseLinkedList(mid);
        mergeTwoLinkedLists(head, reveredLinkedListHead);

        return head;
    }

    private static void mergeTwoLinkedLists(LinkedListNode first, LinkedListNode second) {
        LinkedListNode curr1 = first;
        LinkedListNode curr2 = second;

        while (curr1 != null &&  curr2 != null) {
            LinkedListNode next1 = curr1.next;
            LinkedListNode next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }
}
