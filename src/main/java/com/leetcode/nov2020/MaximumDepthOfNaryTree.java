package com.leetcode.nov2020;

import com.leetcode.HelperClasses.Node;

import java.util.List;

public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {


    }

    public int maxDepth(Node root) {
        if(root == null) return 0;
        else {
            return getMaxDepth(root, 1);
        }

    }

    private int getMaxDepth(Node root, int i) {
        List<Node> children = root.children;
        int maxDepthNode = i;
        for(Node child : children) {
            if(child != null) {
                int maxDepthChild = getMaxDepth(child, i + 1);
                maxDepthNode = Math.max(maxDepthNode, maxDepthChild);
            }
        }
        return maxDepthNode;

    }
}
