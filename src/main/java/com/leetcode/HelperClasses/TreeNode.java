package com.leetcode.HelperClasses;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public  TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode right4 = new TreeNode(1, null , null);
        TreeNode right3 = new TreeNode(2, null, null);
        TreeNode left3 = new TreeNode(3, null, null);
        TreeNode right2 =  new TreeNode(11, null, null);
        TreeNode right1 =  new TreeNode(1, null , null);
        TreeNode left1 =  new TreeNode(5, null, null);
        TreeNode right = new TreeNode(0, null, null);
        TreeNode left =  new TreeNode(9, left1, right1);
        TreeNode root = new TreeNode(4, left , right);
    }
}