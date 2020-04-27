package com.leetcode.AprilChallenge;

public class Day1 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,4,2,3,3,};
        System.out.println(singleNumber(nums));
    }


    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums) {
            res ^= i;
        }
        return res;
    }
}
