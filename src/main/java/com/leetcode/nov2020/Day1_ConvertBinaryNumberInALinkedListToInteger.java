package com.leetcode.nov2020;

import com.leetcode.HelperClasses.ListNode;

import java.util.ArrayList;

public class Day1_ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        int val = head.val;
        while(head.next != null) {
            val = val*2 + head.next.val;
            head =  head.next;
        }
        return val;
    }
}
