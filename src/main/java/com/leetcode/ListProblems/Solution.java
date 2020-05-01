package com.leetcode.ListProblems;

class Solution {

    public static void main(String[] args) {
        ListNode tail1 = new ListNode(3);
        ListNode mid1 = new ListNode(2, tail1);
        ListNode head1 =  new ListNode(1, mid1);


        ListNode tail2 = new ListNode(3);
        ListNode mid2 = new ListNode(2, tail2);
        ListNode head2 =  new ListNode(1, mid2);

//        System.out.println(listNode.val);

        ListNode listNode = mergeTwoLists(head1, head2);


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
        return null;
    }
}





