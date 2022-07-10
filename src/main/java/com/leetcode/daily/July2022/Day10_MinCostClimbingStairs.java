package com.leetcode.daily.July2022;

public class Day10_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] minCost =  new int[length];
        for(int i = 0; i < length; i++) {
            if(i < 2) minCost[i] = cost[i];
            minCost[i] = Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(minCost[length-1], minCost[length-2]);
    }
}
