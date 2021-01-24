package com.AlogrithmsAndDataStructures.DynamicProgramming.Easy;

public class MinCostClimbingStairs {
    private static int[] dp;

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        return minCostBottomUpDP(cost);
    }

    public static int minCostBottomUpDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return  Math.min(dp[n-1], dp[n-2]);

    }

    public static int minCostTopDownDP(int[] cost, int height) {
        if (height < 0) return 0;
        else if (height==0 || height==1) return cost[height];
        else if(dp[height] != 0) return dp[height];
        else {
            dp[height] = cost[height] + Math.min(minCostTopDownDP(cost, height-1), minCostTopDownDP(cost, height-2));
            return dp[height];
        }
    }

    public static int minCostRecursion(int[] cost, int height) {
        if (height < 0) return 0;
        else if (height==0 || height==1) return cost[height];
        else {
            return cost[height] + Math.min(minCostRecursion(cost, height-1), minCostRecursion(cost, height-2));
        }
    }
}
