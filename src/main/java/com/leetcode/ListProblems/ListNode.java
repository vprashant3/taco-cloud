package com.leetcode.ListProblems;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int x){
        val = x;
        next = null;
    }
    ListNode(int x, ListNode nextNode) {
        val = x;
        next =  nextNode;
    }
}