package com.leetcode.may2021;

public class NonDecreasingArray {

    public static void main(String[] args) {
      int[] nums =   {5,7,1,8};
      new NonDecreasingArray().checkPossibility(nums);

    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int pos = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                count++;
                pos = i - 1;
            }
        }
        if(count > 1) return false;
        if(count == 0) return true;

        if(pos == 0) nums[0] = Integer.MIN_VALUE;
        else nums[pos] = nums[pos - 1];

        int countLeft = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                countLeft++;

            }
        }

        if(pos == nums.length - 1) nums[pos] = Integer.MAX_VALUE;
        else nums[pos] = nums[pos + 1];

        int countRight = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                countRight++;

            }
        }


        if(countLeft == 0 || countRight == 0) return true;

        return false;
    }
}
