package com.leetcode.may2021;

import com.leetcode.HelperClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day14_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left, right);
        new Day14_FlattenBinaryTreeToLinkedList().flatten(root);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
            if(!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }


    }



}
