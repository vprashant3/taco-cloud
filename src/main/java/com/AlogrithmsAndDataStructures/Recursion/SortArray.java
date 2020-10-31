package com.AlogrithmsAndDataStructures.Recursion;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] ip = {6,3,2,5,2,1};
        int[] op = sortArrayUsingRecursion(ip, ip.length);
        Arrays.stream(op).forEach(System.out::println);
    }

    private static int[] sortArrayUsingRecursion(int[] ip, int len) {
        if(len == 1) return ip;
        int[] sortedArray = sortArrayUsingRecursion(Arrays.copyOfRange(ip,0,len - 1), len -1);
        int[] res = merge(sortedArray, ip[len - 1]);
        return res;
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

