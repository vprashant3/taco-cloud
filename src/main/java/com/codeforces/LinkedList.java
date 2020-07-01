package com.codeforces;

public class LinkedList {

    private static class Node {
        int val;
        Node nextNode;

        Node(int val, Node node) {
            this.val = val;
            this.nextNode = node;
        }
    }

    public static void main(String[] args) {
        Node n2 =  new Node(2,null);
        Node n1 =  new Node(1, n2);
        Node n0 =  new Node(0, n1);

        reverseIterative(n0);
    }

    private static Node reverseIterative(Node node) {
        Node prev =  null;
        Node curr = node;
        Node next = null;

        while(curr !=  null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr =  next;

        }
        return prev;
    }
}
