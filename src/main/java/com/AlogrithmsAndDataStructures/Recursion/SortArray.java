package com.AlogrithmsAndDataStructures.Recursion;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] ip = {3,2,1,1,5,6,7};
        int[] op = sortArrayUsingRecursion(ip, ip.length);
        Arrays.stream(op).forEach(System.out::println);
    }

    private static int[] sortArrayUsingRecursion(int[] ip, int len) {
        if(len == 1) return ip;
        int[] sortedArray = sortArrayUsingRecursion(Arrays.copyOfRange(ip,0,len - 1), len -1);
        int[] res = mergeUsingRecursion(sortedArray, ip[len - 1]);
        return res;
    }

    private static int[] mergeUsingRecursion(int[] sortedArray, int i) {
        int[] mergedArray = new int[sortedArray.length + 1];
        if(sortedArray.length == 0) {
            mergedArray[0] = i;
        } else if( sortedArray[sortedArray.length - 1] <= i) {
            mergedArray = Arrays.copyOf(sortedArray, sortedArray.length + 1);
            mergedArray[sortedArray.length] = i;
        } else {
            int[] intermediateMerge = mergeUsingRecursion(Arrays.copyOfRange(sortedArray, 0,sortedArray.length - 1), i);
            mergedArray = Arrays.copyOf(intermediateMerge, intermediateMerge.length + 1);
            mergedArray[mergedArray.length - 1] =  sortedArray[sortedArray.length - 1];
        }
        return mergedArray;



    }

    private static int[] merge(int[] sortedArray, int lastElement) {
        int[] res =  new int[sortedArray.length + 1];
        int j = 0;
        boolean isLastElementAdded = false;
        for(int i = 0; i <= sortedArray.length; i++) {
            if(!isLastElementAdded && lastElement < sortedArray[j]) {
                res[i] =  lastElement;
                isLastElementAdded = true;
            } else {
                res[i] = sortedArray[j];
                j++;
            }
        }
        return res;

    }
}

