package com.codingroundpatterns.fastandslowpointers;

import com.codingroundpatterns.LinkedListNode;

public class PalindromeList{
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode mid = findMid(head);
        LinkedListNode reveredLinkedListHead = reverseLinkedList(mid);
        return areBothListsEqual(head, reveredLinkedListHead);
    }

    private static LinkedListNode findMid(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    private static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode newHead = null;
        while(head != null) {
            LinkedListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
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