package com.leetcode.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Day11_Subsets {
    public static void main(String[] args) {

    }

    //iteratively
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        int powerSetElementCount  = (int) Math.pow(2, nums.length);
        for (int i = 0; i < powerSetElementCount ; i++) {
            List<Integer> subset =  new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i & (1 << j))  !=  0) subset.add(nums[j]);
            }
            powerSet.add(subset);

        }
        return powerSet;
    }
}

