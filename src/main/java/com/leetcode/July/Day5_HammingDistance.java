package com.leetcode.July;

public class Day5_HammingDistance {

    public static void main(String[] args) {


    }

    // using in built functionality
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);

    }

}
