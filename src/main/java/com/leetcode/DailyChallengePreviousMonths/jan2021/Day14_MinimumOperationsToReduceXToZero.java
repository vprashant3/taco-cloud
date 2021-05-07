package com.leetcode.DailyChallengePreviousMonths.jan2021;

import java.util.Arrays;

public class Day14_MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        int n = nums.length, windowSize = -1, current = 0;

        for (int right = 0, left = 0; right < n; right++) {
            current += nums[right];
            while (current > target && left <= right)
                current -= nums[left++];

            if (current == target)
                windowSize = Math.max(windowSize, right - left + 1);
        }
        return windowSize != -1 ? n - windowSize : -1;
    }

}
