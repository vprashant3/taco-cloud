package com.leetcode.MayChallenge;

public class Day1 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end =  n;
        boolean step;
        if(isBadVersion(1)) return 1;
        while(true) {
            int mid=start + (end-start)/2;
            boolean resMid = isBadVersion(mid);
            if(resMid) {
                step = isBadVersion(mid-1);
                if(!step) return mid;
                else end = mid-1;
            } else {
                step = isBadVersion(mid+1);
                if(step) return mid+1;
                else start = mid+1;
            }
        }
    }

    public static boolean isBadVersion(int n) {
        return n >=  1702766719 ? true : false;
    }
}
