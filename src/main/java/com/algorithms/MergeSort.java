package com.algorithms;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] input = {2,4,1,9,10,11,5,7};
        
        mergeSort(input);

        Arrays.stream(input).forEach(System.out::println);

    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;
        if(inputLength < 2) return;

        int mid =  inputLength/2;
        int[] leftArray = Arrays.copyOfRange(inputArray,0, mid);
        int[] rightArray = Arrays.copyOfRange(inputArray, mid, inputLength);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(inputArray, leftArray, rightArray);

    }

    private static void merge(int[] inputArray, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i] <= rightArray[j]) {
                inputArray[k++] = leftArray[i++];
            } else {
                inputArray[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            inputArray[k++] =  leftArray[i++];
        }

        while ( j < rightArray.length) {
            inputArray[k++] = rightArray[j++];
        }
    }

}
