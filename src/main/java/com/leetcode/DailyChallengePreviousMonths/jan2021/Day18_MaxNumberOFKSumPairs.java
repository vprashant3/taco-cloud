package com.leetcode.DailyChallengePreviousMonths.jan2021;

import java.util.Arrays;

public class Day18_MaxNumberOFKSumPairs {

    public static void main(String[] args) {
        int k = 5;
        int[] nums = {1,2,3,4};
        new Day18_MaxNumberOFKSumPairs().maxOperations(nums,k);
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, pairs = 0;

        while(left < right) {
            if(nums[left] + nums[right] == k) {
                left++;
                right--;
                pairs++;
            } else if(nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return pairs;
    }
}
