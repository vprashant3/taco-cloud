package com.algorithms;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] input = {2,4, 1, 9, 2, 1};

        countingSort(input);
    }

    private static void countingSort(int[] input) {
        int[] countArray =  new int[10];

        Arrays.stream(input).forEach(i -> countArray[i] +=1);

        for(int i=0; i<10; i++) {
            if(countArray[i] != 0){
                int j = countArray[i];
                while (j-- > 0){
                    System.out.println(i);
                }
            }
        }

    }
}
