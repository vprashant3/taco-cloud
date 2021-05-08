package com.leetcode.may2021;


import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {0,2,3};
        new JumpGame().canJump(nums);
    }

    public int canJump(int[] nums) {
        int[] minJump = new int[nums.length];
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;

        for(int i = 0; i < nums.length -1; i++) {
            if(minJump[i] != Integer.MAX_VALUE) {
                int maxJumpFromCurrentPos = nums[i];
                while (maxJumpFromCurrentPos >= 0) {
                    if (i + maxJumpFromCurrentPos < nums.length) {
                        minJump[i + maxJumpFromCurrentPos] = Math.min(minJump[i] + 1, minJump[i + maxJumpFromCurrentPos]);
                    }
                    maxJumpFromCurrentPos--;
                }
            }
        }

        return minJump[nums.length - 1];
    }
}
