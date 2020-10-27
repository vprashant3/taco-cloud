package com.AlogrithmsAndDataStructures.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new HouseRobber().rob(nums));
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robRecursiveWithMemoization(nums, 0, memo);
    }

    private int robRecursive(int[] nums, int startPoint) {
        //base condition
        if(startPoint >= nums.length) return 0;
        // recursion
        return Math.max(nums[startPoint] + robRecursive(nums, startPoint + 2), robRecursive(nums, startPoint + 1));

    }


    private int robRecursiveWithMemoization(int[] nums, int startPoint, int[] memo) {
        if(startPoint >= nums.length) return 0;
        if(memo[startPoint] == -1)
            memo[startPoint] = Math.max(nums[startPoint] + robRecursiveWithMemoization(nums, startPoint + 2, memo), robRecursiveWithMemoization(nums, startPoint + 1, memo));
        return memo[startPoint];
    }
}
