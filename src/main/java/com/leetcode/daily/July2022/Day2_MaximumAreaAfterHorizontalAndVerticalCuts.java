package com.leetcode.daily.July2022;

import java.util.Arrays;

public class Day2_MaximumAreaAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) ((getMaxDist(h, horizontalCuts) * getMaxDist(w, verticalCuts)) % (Math.pow(10, 9) + 7));
    }

    private static long getMaxDist(int end, int[] cuts) {
        Arrays.sort(cuts);
        long res = 0, from = 0;
        for (int c : cuts) {
            res = Math.max(res, c - from);
            from = c;
        }
        return Math.max(res, end - from);
    }
}
