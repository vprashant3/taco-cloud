package com.leetcode.may2021;

import com.leetcode.HelperClasses.TreeNode;

import java.util.*;

public class Day14_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left, right);
        new Day14_FlattenBinaryTreeToLinkedList().flatten(root);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while(!deque.isEmpty()) {
            TreeNode curNode = deque.pop();
            if(curNode.right != null) {
                deque.push(curNode.right);
            }
            if(curNode.left != null) {
                deque.push(curNode.left);
            }
            if(!deque.isEmpty()) curNode.right = deque.peek();
            curNode.left = null;
        }


    }



}
