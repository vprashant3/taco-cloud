package com.AlogrithmsAndDataStructures.Algorithms;

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[] input){
        int temp;
        for(int i=1; i<input.length; i++) {
            for(int j=i; j>=1; j--) {
                if(input[j] < input[j-1]) {
                    temp =  input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {5,2,4,6,1,3};
        insertionSort(inputArray);
        Arrays.stream(inputArray).forEach(System.out::println);
    }

}
