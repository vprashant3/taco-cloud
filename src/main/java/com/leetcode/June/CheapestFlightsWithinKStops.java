package com.leetcode.June;

import com.leetcode.ListProblems.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheapestFlightsWithinKStops {

     public static List<String> list = new ArrayList<>();

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

        int i = sumNumbers(root);
        System.out.println(i);


    }

    public static int sumNumbers(TreeNode root) {
        getAllIntegers(root,"");
        int sum = list.stream().map(Integer::parseInt).mapToInt(i ->i).sum();
        list.clear();
        return sum;

    }

    private static void getAllIntegers(TreeNode root, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(path+root.val);
        }
        if(root.left != null) {
            getAllIntegers(root.left, path+root.val);
        }
        if(root.right != null) {
            getAllIntegers(root.right, path + root.val);
        }

    }


}
