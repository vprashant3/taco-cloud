package com.leetcode.ArrayProblems;


import java.util.Random;
import java.util.stream.IntStream;

public class ShuffleAnArray {

    public static void main(String[]  args) {
       int[] inputArray = {2, 3, 4, 5, 6, 7};
       int[] outputArray =  shuffledArray(inputArray);
       for(int i = 0; i< outputArray.length; i++) {
           System.out.println(outputArray[i]);
       }
    }




    // take a random value from inputArray, assign to outputArray, then remove the random value from inputarray and reduce its size
    // time complexity O(n2)
    private static int[] shuffledArray(int[] inputArray) {
        Random r = new Random();
        int[] outputArray = new int[inputArray.length];
        int[] reducedArray = inputArray;
        for(int i=0; i<inputArray.length; i++) {
            int length = reducedArray.length;
            int randomLocation = r.nextInt(length);
            outputArray[i] = reducedArray[randomLocation];
            int[] finalReducedArray = reducedArray;
            int[] tempArray = IntStream.range(0,length).filter(loc -> loc != randomLocation).map(loc -> finalReducedArray[loc]).toArray();
            reducedArray = tempArray;
        }


        return outputArray;
    }
}
