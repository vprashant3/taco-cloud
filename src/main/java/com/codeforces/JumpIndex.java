package com.codeforces;

public class JumpIndex {

    public boolean canJump(int[] nums) {
        boolean[] index = new boolean[nums.length];
        index[nums.length-1] = true;

        for (int i = nums.length -2; i >=0 ; i--) {
            int canJumpTo = i+nums[i];
            if(canJumpTo <= nums.length-1 && index[canJumpTo]) {
                index[i] = true;
            } else {
                index[i] = false;
            }
        }
        return index[0];
    }
}
