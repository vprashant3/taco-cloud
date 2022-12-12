package com.codingroundpatterns.fastandslowpointers;

public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {
        // Write your code here
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head.next;
        while(fastPointer != null &&
                fastPointer.data != slowPointer.data) {
            if(slowPointer.next == null ) return false;
            slowPointer = slowPointer.next;

            if(fastPointer.next == null || fastPointer.next.next == null) return false;
            fastPointer = fastPointer.next.next;
        }
        return fastPointer != null;
    }
}