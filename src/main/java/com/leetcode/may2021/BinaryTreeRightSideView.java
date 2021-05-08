package com.leetcode.may2021;

import com.leetcode.HelperClasses.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return null;
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> parentNodes =  new LinkedList<>();
        parentNodes.add(root);
        while(!parentNodes.isEmpty()) {
            TreeNode peek = parentNodes.peek();
            rightView.add(peek.val);
            parentNodes = getAllChildNodes(parentNodes);
        }
        return rightView;
    }

    Queue<TreeNode> getAllChildNodes(Queue<TreeNode> parentNodes)  {
        Queue<TreeNode> childNodes =  new LinkedList<>();
        while(!parentNodes.isEmpty()) {
            TreeNode node =  parentNodes.remove();
            if(node.right != null) childNodes.add(node.right);
            if(node.left != null) childNodes.add(node.left);
        }
        return  childNodes;
    }
}
