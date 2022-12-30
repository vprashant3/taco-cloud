package com.codingroundpatterns;

public class Utils {

    public static LinkedListNode findMid(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode newHead = null;
        while(head != null) {
            LinkedListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
