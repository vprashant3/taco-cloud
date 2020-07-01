package com.FunctionalJava;

import java.util.HashMap;

public class FindPairs {

    public static void main(String[] args) {
        int[] arr =  {12, 2, 33, 43, 6};
        int  m = 10;

        // value is used to store the current element and
        // key is used to store possible pair values
        HashMap<Integer,Integer>  hashMap = new HashMap<>();

        // O(n) time complexity as looping through array once
        for(int i : arr) {
            if(hashMap.containsKey(i)) {
                // when we find a match in key, we know we have found a pair
                System.out.println("pair found : "+  i +" , "+ hashMap.get(i));
            } else {
                // when we find 12, we store 22 and -2 as keys
                hashMap.put(i+m, i);
                hashMap.put(i-m, i);
            }
        }


    }
}
