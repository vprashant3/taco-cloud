package com.leetcode.ListProblems;

import java.util.HashSet;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        ListNode tail1 = null;
        ListNode mid1 = new ListNode(2, tail1);
        ListNode head1 =  new ListNode(3, mid1);
        ListNode tail2 = new ListNode(-4,mid1);
        tail1 = new ListNode(0,tail2);




//        ListNode tail2 = new ListNode(3);
//        ListNode mid2 = new ListNode(2, tail2);
//        ListNode head2 =  new ListNode(1, mid2);

//        System.out.println(listNode.val);

//        ListNode listNode = mergeTwoLists(head1, head2);

        System.out.println(hasCycle(head1));


    }

    public static ListNode reverseListIteratively(ListNode input) {
        ListNode head = input;
        ListNode curNode = head;
        while(curNode.next != null) {
            ListNode nextNode =  curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }
        curNode = head;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
        return null;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode prev = ans;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            prev.next = l2;
        }
        if (l2 == null) {
            prev.next = l1;
        }

        return ans.next;
    }


    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        while(head != null) {
            if(seen.contains(head)) return true;
            else seen.add(head);
            head = head.next;
        }
        return false;
    }
}





