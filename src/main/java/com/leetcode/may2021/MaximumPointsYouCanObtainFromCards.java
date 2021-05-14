package com.leetcode.may2021;

import ch.qos.logback.core.net.SyslogOutputStream;

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int k = 3;
        int[] cardPoints = {1,2,3,4,5,6,1};

        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(cardPoints, k));
    }

    public int maxScore(int[] cardPoints, int k) {
        int minSubArrayLength = cardPoints.length - k;
        int start = 0;
        int end = 0;
        int curSum = 0;
        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;

        for(int i = 0; i < cardPoints.length; i++) {
            totalSum += cardPoints[i];
            if(end - start < minSubArrayLength) {
                curSum += cardPoints[i];
                end++;
            } else {
                minSum = Math.min(minSum, curSum);
                curSum += cardPoints[end] - cardPoints[start];
                start++;
                end++;
            }
        }

        return minSum == Integer.MIN_VALUE ? totalSum : totalSum - minSum;



    }

}
