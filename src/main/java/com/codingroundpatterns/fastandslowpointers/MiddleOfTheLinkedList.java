package com.codingroundpatterns.fastandslowpointers;

import com.codingroundpatterns.LinkedListNode;

import static com.codingroundpatterns.Utils.findMid;

public class MiddleOfTheLinkedList {

    public static LinkedListNode middleNode(LinkedListNode head) {
        return findMid(head);
    }
}
