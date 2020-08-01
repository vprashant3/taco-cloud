package com.leetcode.DailyChallengePreviousMonths.July2020;

import com.leetcode.HelperClasses.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Day9_MaxiumWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode t6 = new TreeNode(9, null, null);
        TreeNode t5 = new TreeNode(3, null, null);
        TreeNode t4 = new TreeNode(5, null, null);
        TreeNode t3 =  new TreeNode(2, null, t6);
        TreeNode t2 = new TreeNode(3, t4, t5);
        TreeNode t1 =  new TreeNode(1, t2, t3);
        int i = new Day9_MaxiumWidthOfBinaryTree().widthOfBinaryTree(t1);
        System.out.println(i);
    }

    //BFS
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int maxWidth = 0;
        int curWidth = 0;

        while (!deque.isEmpty()) {
            curWidth = deque.size();
            maxWidth = Math.max(maxWidth, curWidth);
            while(curWidth-- > 0) {
                TreeNode node =  deque.poll();
                if(node == null) {
                    deque.add(null);
                    deque.add(null);
                } else {
                    deque.add(node.left);
                    deque.add(node.right);
                }
                while (!deque.isEmpty() && deque.peekFirst() == null) deque.pollFirst();
                while (!deque.isEmpty() && deque.peekLast() == null) deque.pollLast();
            }
        }
        return 0;
    }


    //DFS
    public int widthOfBinaryTreeDFS(TreeNode root) {
        if(root == null) return 0;
        Map<Integer, Integer[] > widthMap =  new HashMap<>();
        fillWidthMap(root, 0 , widthMap, 0);
        int maxWidth = 0;
        for(Integer[] i : widthMap.values()) {
            maxWidth = Math.max((i[1] - i[0]), maxWidth);
        }
        return maxWidth+1;
    }

    private void fillWidthMap(TreeNode root, int i, Map<Integer, Integer[]> map, int index)  {
        if(root != null) {
            Integer[] arr =  map.getOrDefault(i, new Integer[] {index, index});
            arr[1] = Math.max(arr[1], index);
            arr[0] = Math.min(arr[0], index);
            map.put(i, arr);
        }
        if(root.right != null) fillWidthMap(root.right, i+1, map , 2*index+1);
        if(root.left != null) fillWidthMap(root.left, i+1, map, 2*index+2);
    }
}
