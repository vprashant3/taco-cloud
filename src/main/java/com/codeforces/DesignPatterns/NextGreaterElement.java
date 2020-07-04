package com.codeforces.DesignPatterns;

import com.leetcode.Starter.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class NextGreaterElement {
    public static Map<Integer,List<Integer>> levelMap = new TreeMap<>();
    public static void main(String[] args) {
        int[] T = {1,2,3,4,5,3,2};
        searchInBitonicArray(T,3, 0, T.length-1);


    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  res =  new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < level; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            res.add(subList);
        }
        return res;
    }

    public static boolean searchInBitonicArray(int[] t, int i, int left, int right) {
        int mid = left + (right-left)/2;
        if(t[mid] == i) return true;
        else if( mid-i > left && t[mid-1] > i) {
           return searchInBitonicArray(t,i, left, mid-1);
        } else if( mid+i < right && t[mid+1] < i) {
            return searchInBitonicArray(t,i, left, mid-1);
        }
        return false;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        createLevelMap(root, 1);
        Set<Map.Entry<Integer, List<Integer>>> values = levelMap.entrySet();
        List<List<Integer>> result =  new ArrayList<>();
        for(Map.Entry i : values) {
            List<Integer> levelValues=  (List<Integer>) i.getValue();
                result.add(levelValues);
        }
        return result;


    }

    private void createLevelMap(TreeNode node, int level) {
        if(node !=  null) {
            List<Integer> list = levelMap.getOrDefault(level, new ArrayList<>());
            list.add(node.val);
            levelMap.put(level, list);
            if(level % 2 ==0) {
                if (node.left != null) createLevelMap(node.left, level + 1);
                if (node.right != null) createLevelMap(node.right, level + 1);
            } else {
                if (node.right != null) createLevelMap(node.right, level + 1);
                if (node.left != null) createLevelMap(node.left, level + 1);
            }

        }
    }

    public int maxSubArrayDP(int[] nums) {
        int[] dp =  new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-1],0);
            max =  Math.max(max, dp[i]);
        }


        return max;
    }


    public int maxSubArrayKadane(int[] nums) {
        int curr_max = nums[0]; // local maxima
        int max_so_far = nums[0]; //global maxima

        for(int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_far = Math.max(curr_max, max_so_far);
        }
        return max_so_far;
    }

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        int j = 0;
        for(int i : T) {
            while(!stack.isEmpty() && i > stack.peek()) {
                res[j] = stack.size();
                stack.pop();
                j++;
            }
            stack.add(i);
        }
        return res;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i : nums2) {
            while(!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] =  map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void easy2 () {
        int[] input = {4,5,2,25};
        Stack<Integer> stack =  new Stack<>();
        for( int i : input) {
            while(!stack.isEmpty() && stack.peek() < i)
                System.out.println(stack.pop()+"  "+i);
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+"  "+"-1");
        }
    }
    // soln 1
    public void easy1 () {
        int[] input = {4,5,2,25};
        Stack<Integer> stack =  new Stack<>();

        stack.push(input[0]);
        int next;
        int element;

        for(int i = 1; i < input.length; i++) {
            next = input[i];
            if(!stack.isEmpty()) {
                element = stack.pop();
                while( element < next) {
                    System.out.println(element +"--->"+ next);
                    if(stack.isEmpty()) break;
                    element = stack.pop();
                }
                if(element > next) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() +"--->"+"-1");
        }

    }


}
