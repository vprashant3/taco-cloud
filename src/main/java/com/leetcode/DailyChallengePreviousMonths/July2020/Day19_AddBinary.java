package com.leetcode.DailyChallengePreviousMonths.July2020;

public class Day19_AddBinary {
    public static void main(String[] args) {

    }


    // fails for really long nums
    public String addBinaryInbuiltMethods(String a, String b) {
        long ai = Long.parseLong(a, 2);
        long bi = Long.parseLong(b, 2);
        return Long.toBinaryString(ai + bi);
    }
}
