package com.algorithms;

import java.util.Arrays;

public class PeakFinder {

    public static int findPeaks(int[] input) {
        int mid = (input.length)/2;
        if(input[mid]<input[mid-1] ) {
            findPeaks(Arrays.copyOfRange(input,0,mid-1));
        }else if(input[mid]<input[mid+1]) {
            findPeaks(Arrays.copyOfRange(input,mid+1,input.length-1));
        }else {
            return input[mid];
        }
        return 0;
    }

}
