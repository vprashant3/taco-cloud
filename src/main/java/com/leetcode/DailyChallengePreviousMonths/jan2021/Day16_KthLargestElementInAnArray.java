package com.leetcode.DailyChallengePreviousMonths.jan2021;

import java.util.Stack;

public class Day16_KthLargestElementInAnArray {

    public static void main(String[] args) {
        int k  = 2;
        int[] nums =  {3,2,1,5,6,4};
        int kthLargest = new Day16_KthLargestElementInAnArray().findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            sortStack(stack, nums[i]);
            while(stack.size() > k) stack.pop();
        }


        return stack.pop();
    }

    private void sortStack(Stack<Integer> stack, int val) {
        if(stack.isEmpty() || val <= stack.peek()) {
            stack.push(val);
        } else {
            int top = stack.pop();
            sortStack(stack, val);
            stack.push(top);
        }

    }
}
