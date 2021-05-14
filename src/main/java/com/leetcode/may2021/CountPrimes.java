package com.leetcode.may2021;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
    }

    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 0;
        boolean[] isPrime =  new boolean[n + 1];

        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(isPrime[i] == false) {
                for (int j = i * i; j < n; j += i) {
                        isPrime[j] = true;
                }
            }
        }


        for(int i = 2; i <= n; i++) {
            if(isPrime[i] == true) count++;
        }
        return count;


    }


}
