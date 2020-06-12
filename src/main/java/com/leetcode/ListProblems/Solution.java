package com.leetcode.ListProblems;


import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int []nums = {1,3};
        int target = 3;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;

        int start = 0;
        int end =  nums.length-1;
        while(start < end) {
            int mid =  start + ((end-start)/2);
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target && nums[mid+1] > target) return mid+1;
            else if(nums[mid] > target && nums[mid-1] < target) return mid;
            else if(nums[mid] < target)  start = mid;
            else if(nums[mid] > target)  end =  mid;
        }

        return 0;
    }



}












