package com.leetcode.June;

import java.util.Arrays;

public class PerfectSquares {

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
