package com.leetcode.HelperClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int x){
        val = x;
        next = null;
    }
    ListNode(int x, ListNode nextNode) {
        val = x;
        next =  nextNode;
    }

    public static class CheapestFlightsWithinKStops {

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

    public static class PerfectSquares {

        public static void main(String[] args) {
    //        System.out.println(numSquares(12));
              int[] nums  = {3,4,2,3};
              System.out.println(checkPossibility(nums));
        }

        public static int numSquares(int n) {
            int[] ans = new int[n+1];
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[0] = 0;

            for (int i = 1; i <= n; i++) {
                int min =  Integer.MAX_VALUE;
                int j = 1;
                while(i - j*j > 0) {
                    min = Math.min(min, ans[i - j*j]+1);
                    j++;
                }
                ans[i] = min;
            }
            return ans[n];

        }

        public static boolean checkPossibility(int[] nums) {
            int count = 0;
            for(int i = 1; i< nums.length; i++) {
                if(nums[i] < nums[i-1]) {
                    nums[i] = nums[i-1];
                    count++;
                }
            }
            for(int i = 1; i< nums.length; i++) {
                if(nums[i] < nums[i-1]) {
                    count++;
                }
            }
            return count <= 1 ? true : false;
        }



    }

    public static class ReconstructItinerary {

        Map<String, PriorityQueue<String>> flights;
        LinkedList<String> path;

        public static void main(String[] args) {
            ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
            List<List<String>> input = Arrays.asList(
                    Arrays.asList("JFK", "KUL"),
                    Arrays.asList("JFK", "NRT"),
                    Arrays.asList("NRT", "JFK"));
            List<String> itinerary = reconstructItinerary.findItinerary(input);
            System.out.println(itinerary);

        }


        public List<String> findItinerary(List<List<String>> tickets) {
            flights = new HashMap<>();
            path = new LinkedList<>();
            for (List<String> ticket : tickets) {
                flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                flights.get(ticket.get(0)).add(ticket.get(1));
            }
            dfs("JFK");
            return path;
        }

        public void dfs(String departure) {
            PriorityQueue<String> arrivals = flights.get(departure);
            while (arrivals != null && !arrivals.isEmpty())
                dfs(arrivals.poll());
            path.addFirst(departure);
        }
    }
}