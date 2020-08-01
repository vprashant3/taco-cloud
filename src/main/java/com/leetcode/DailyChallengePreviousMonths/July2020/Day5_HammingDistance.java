package com.leetcode.DailyChallengePreviousMonths.July2020;

import java.util.Arrays;

public class Day5_HammingDistance {

    public static void main(String[] args) {


    }

    // using in built functionality
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);

    }

    public int missingNumber(int[] nums) {
       int len = nums.length;
       int sum =  (len * (len + 1)) / 2;
       int actualSum = Arrays.stream(nums).sum();
       return sum - actualSum;


    }

}
