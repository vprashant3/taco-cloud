package com.leetcode.DailyChallengePreviousMonths.jan2021;

public class Day15_GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        int max = Integer.MIN_VALUE;
        int i = 1;

        int[] generatedArray =  new int[n + 1];

        generatedArray[0] = 0;
        if(n == 0) return generatedArray[0];

        generatedArray[1] = 1;
        if(n == 1) return generatedArray[1];

        while(2 * i <= n) {
            generatedArray[2 * i] = generatedArray[i];
            if(generatedArray[2 * 1] > max) max = generatedArray[2 * i];
            if(2 * i + 1 <= n) {
                generatedArray[2 * i + 1] = generatedArray[i] + generatedArray[i + 1];
                if(generatedArray[2 * i + 1] > max) max = generatedArray[2 * i + 1];
            }
        }

        return max;
    }
}
