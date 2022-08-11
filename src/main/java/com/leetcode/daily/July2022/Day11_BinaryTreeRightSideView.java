package com.leetcode.daily.July2022;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day11_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null) return rightSideView;
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            rightSideView.add(curLevel.get(curLevel.size() - 1).val);
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode node : curLevel) {
                if(node != null && node.left != null) nextLevel.add(node.left);
                if(node != null && node.right != null) nextLevel.add(node.right);
            }
            curLevel = nextLevel;
        }
        return rightSideView;
    }
}
