package com.codingroundpatterns.twoPointers;

import java.util.*;

public class SumOfThree {

    public static boolean findSumOfThree(int[] nums, int target) {
        int low, high, sum;
        Arrays.sort(nums);
        for(int curIndex = 0; curIndex < nums.length - 1; curIndex++) {
            low = curIndex + 1;
            high = nums.length - 1;
            while (low < high) {
                sum = nums[curIndex] + nums[low] + nums[high];
                if (sum == target) return true;
                else if (sum <= target) low++;
                else high--;
            }

        }
        return false;
    }
}