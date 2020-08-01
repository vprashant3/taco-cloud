package com.leetcode.DailyChallengePreviousMonths.July2020;

public class Day1_ArrangingCoins {

    public static void main(String[] args) {

    }

    // iterative
    public int arrangeCoinsItereative(int n) {
        int i = 0;
        while(n-i >= 0) {
            n = n-i;
            i++;
        }
        return i-1;
    }

    //math
    public int arrangeCoinsMath(int n) {
        return  (int) (Math.sqrt(2*(long)n+0.25)-0.5);
    }

    //binaryserach
    public int arrangeCoinsBinarySearch(int n) {
        long left = 0;
        long  right = n;
        long curr;
        long k;
        while(left <= right) {
            k = left +(right-left)/2;
            curr = (k*(k+1))/2;
            if(curr == n) return (int)k;
            if( n < curr) {
                right = k-1;
            } else {
                left = k+1;
            }
        }
        return (int)right;
    }
}
