package com.codingroundpatterns.fastandslowpointers;

import com.codingroundpatterns.LinkedListNode;

public class MiddleOfTheLinkedList {

    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while(fastPointer != null) {
            fastPointer = fastPointer.next;
            if(fastPointer == null) break;
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}
