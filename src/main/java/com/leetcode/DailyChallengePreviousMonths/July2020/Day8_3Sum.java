package com.leetcode.DailyChallengePreviousMonths.July2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day8_3Sum {
    public Set<String>  set =  new HashSet<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = new Day8_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }


    private List<List<Integer>> threeSum(int[] ints) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            int x = ints[i];  // -1
            Map<Integer, Integer> map =  new HashMap<>();
            for(int j = i + 1; j < ints.length; j++) {
                int y = ints[j]; // 0 , 1
                int key =  -y - x; //+1 , 0
                if(!map.containsKey(key)) map.put(key, y);
                else res.add(Arrays.asList(x, y, key));
            }
        }
        return res;
    }

    // sort array, then use two pointer to find sum
    private List<List<Integer>> threeSumTwoPointer(int[] ints) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(ints);
        for (int i = 0; i < ints.length -2; i++) {
            int j = i + 1;
            int k = ints.length - 1;
            while(j  < k ) {
                int sum = ints[i] + ints[j] + ints[k];
                if(sum == 0) {
                    set.add(Arrays.asList(ints[i], ints[j++], ints[k--]));
                } else if(sum > 0) k--;
                else  j++;
            }

        }
        return new ArrayList<>(set);
    }


    // brute force O(n3) TLE
    public List<List<Integer>> threeSumBruteForece(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int len =  nums.length;
        for (int i = 0; i < len ; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len ; k++) {
                    if( nums[i] + nums[j] + nums[k] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    }
                }
            }
        }
        return new ArrayList<>(set);
    }


}
