package com.LeetCode.Learning;

public class Test {

    public static void main(String[] args) {


    }

    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start =  0;
        int end =  nums.length-1;

        if(nums[end] > nums[start]) return nums[start];

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == nums[end]) end--;
            else if(nums[mid] > nums[start]) start =  mid + 1;
            else end =  mid - 1;


        }
        return nums[start];

    }


}
