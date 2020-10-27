package com.AlogrithmsAndDataStructures.DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new ClimbingStairs().climbStairs(n));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStairsRecursiveWithMemoization(0, n, memo);
    }

    private int climbStairsRecursive(int i, int n) {
         if(i > n) return 0;
         if(i == n) return 1;
         return climbStairsRecursive(i+1, n) + climbStairsRecursive(i+2, n);
    }

    private int climbStairsRecursiveWithMemoization(int i, int n, int[] memo) {
        if(i > n) return 0;
        if(i == n) return 1;
        if(memo[i] ==  -1)
            memo[i] =  climbStairsRecursiveWithMemoization(i+1, n, memo) + climbStairsRecursiveWithMemoization(i+2, n, memo);
        return memo[i];
    }


}
