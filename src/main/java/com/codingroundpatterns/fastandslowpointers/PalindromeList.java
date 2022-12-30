package com.codingroundpatterns.fastandslowpointers;

import com.codingroundpatterns.LinkedListNode;

import static com.codingroundpatterns.Utils.findMid;
import static com.codingroundpatterns.Utils.reverseLinkedList;

public class PalindromeList{
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode mid = findMid(head);
        LinkedListNode reveredLinkedListHead = reverseLinkedList(mid);
        return areBothListsEqual(head, reveredLinkedListHead);
    }

    private static boolean areBothListsEqual(LinkedListNode head, LinkedListNode reveredLinkedListHead) {
        while(reveredLinkedListHead != null) {
            if(head.data != reveredLinkedListHead.data) return false;
            head = head.next;
            reveredLinkedListHead = reveredLinkedListHead.next;
        }
        return true;
    }
}