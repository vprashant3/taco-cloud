package com.leetcode.HelperClasses;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static class Day1 {

        public static void main(String[] args) {
            System.out.println(firstBadVersion(2126753390));
        }

        public static int firstBadVersion(int n) {
            int start = 1;
            int end =  n;
            boolean step;
            if(isBadVersion(1)) return 1;
            while(true) {
                int mid=start + (end-start)/2;
                boolean resMid = isBadVersion(mid);
                if(resMid) {
                    step = isBadVersion(mid-1);
                    if(!step) return mid;
                    else end = mid-1;
                } else {
                    step = isBadVersion(mid+1);
                    if(step) return mid+1;
                    else start = mid+1;
                }
            }
        }

        public static boolean isBadVersion(int n) {
            return n >=  1702766719 ? true : false;
        }
    }

    public static class Day2 {

        public static void main(String[] args) {
            String J =  "aAb";
            String S = "aAAbbbb";
            System.out.println(numJewelsInStones(J,S));

        }

        public static int numJewelsInStones(String J, String S) {
            Set<Character> set = new HashSet<>();
            int ans = 0;
            for(char c : J.toCharArray()) set.add(c);
            for(char c : S.toCharArray()) {
                if(set.contains(c))
                    ans++;
            }
            return ans;
        }
    }
}