package com.LeetCode.DailyChallengePreviousMonths.July2020;

public class Day12_reverseBits {

    public static void main(String[] args) {
        new Day12_reverseBits().reverseBits(43261596);
    }

    //reverse without loop as in java inbuilt method Integer.reverse(int n)
    private int reverseBits(int n) {
        n = (n >> 16) | (n << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }


    //iteratively one bit at a time
    public int reverseBitsOneBit(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = (reverse << 1) | (n & 1);
            n = n >> 1;
        }
        return reverse;
    }

    // using inbuilt function
    public int reverseBitsInBuiltMethods(int n) {
       return Integer.reverse(n);
    }
}
