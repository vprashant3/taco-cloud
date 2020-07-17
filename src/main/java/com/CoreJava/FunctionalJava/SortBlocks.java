package com.CoreJava.FunctionalJava;

public class SortBlocks {

    public static void main(String[] args) {
        // an array to simulate the given blocks
        int[] arr = {1,8,3,6,5,4,7,2};

        // array for storing sorted elements
        int[] sortedArray =  new int[arr.length];

        //using two pointers to pick the elements
        int start = 0;
        int end =  arr.length-1;

        // Time complexity O(n)
        // Space complexity O(n)
        for(int i = 0; i < arr.length; i +=2) {
            sortedArray[i] = arr[start];
            sortedArray[i+1] = arr[end];
            start += 2;
            end -= 2;
        }

        for(int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }

    }
}
