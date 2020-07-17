package com.LeetCode.July;

import java.util.Deque;
import java.util.LinkedList;

public class Day10_FlattenAMultilevelDoublyLinkedList {


    // itereate O(n)
    public Node flatten(Node head) {
        Deque<Node> stack = new LinkedList<>();
        Node n1  = new Node(0, null, head, null);
        Node curNode = head;

        while(curNode != null || !stack.isEmpty()) {
            if(curNode.child != null) {
                Node child = curNode.child;
                Node next = curNode.next;
                if(next != null) stack.push(next);
                curNode.next = child;
                curNode.child = null;
                child.prev =  curNode;
            } else if(curNode.next == null && !stack.isEmpty()) {
                Node stackNode = stack.pop();
                curNode.next = stackNode;
                stackNode.prev = curNode;
            }
            curNode = curNode.next;
        }

        return n1.next;
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int i, Node prev, Node next, Node child) {
        this.val = i;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
