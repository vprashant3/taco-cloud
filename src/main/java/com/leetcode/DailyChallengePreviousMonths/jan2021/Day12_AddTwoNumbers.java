package com.leetcode.DailyChallengePreviousMonths.jan2021;

import com.leetcode.HelperClasses.ListNode;

public class Day12_AddTwoNumbers {

    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevNode = new ListNode();
        ListNode curNode = new ListNode(0);
        prevNode.next = curNode;
        int carry = 0;
        int curSum;

        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                curSum =  l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                curSum =  l1.val + carry;
                l1 = l1.next;
            } else {
                curSum = l2.val + carry;
                l2 = l2.next;
            }
            curNode.val =  curSum % 10;
            carry = curSum / 10;
            if(l1 != null || l2 != null) {
                ListNode nextNode = new ListNode();
                curNode.next = nextNode;
                curNode = nextNode;
            }

        }

        if(carry != 0) {
            ListNode nextNode = new ListNode(carry);
            curNode.next = nextNode;
        }
        return  prevNode.next;
    }

}
