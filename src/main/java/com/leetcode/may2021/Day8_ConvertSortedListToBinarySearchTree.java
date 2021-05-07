package com.leetcode.may2021;

import com.leetcode.HelperClasses.ListNode;
import com.leetcode.HelperClasses.TreeNode;

public class Day8_ConvertSortedListToBinarySearchTree {



    // solution 1 : convert ListNode to Array, then make the mid element as root
    public TreeNode sortedListToBST(ListNode head) {
       if(head == null) return null;
       int[] elements =  convertListToArray(head);
       int start = 0;
       int end = elements.length - 1;
       return generateBalancedBst(elements, start, end);
    }

    private TreeNode generateBalancedBst(int[] elements, int start, int end) {
        if(start > end) return null;
        else if(start == end) return new TreeNode(elements[start]);
        else {
            int mid = start + (end - start)/2;
            TreeNode root = new TreeNode();
            TreeNode left =  generateBalancedBst(elements, start, mid -1);
            TreeNode right = generateBalancedBst(elements, mid+1, end);
            root.left = left;
            root.right = right;
            return root;
        }

    }

    private int[] convertListToArray(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        int[] array = new int[size];
        cur = head;
        int pos = 0;
        while(cur != null) {
            array[pos] = cur.val;
            cur = cur.next;
        }
        return array;
    }
}
